package com.gitschwifty.cs2340.gatech.space_trader.Model;

    public enum GoodsList {
        WATER("Water", TechLevel.PreAgriculture, TechLevel.PreAgriculture, TechLevel.Medieval, 30, 3, 4, Resources.LOTSOFWATER, Resources.DESERT, 30, 50),
        FURS("Furs", TechLevel.PreAgriculture, TechLevel.PreAgriculture, TechLevel.PreAgriculture, 250, 10, 10, Resources.RICHFAUNA, Resources.LIFELESS, 230, 280),
        FOOD("Food", TechLevel.Agriculture, TechLevel.PreAgriculture, TechLevel.Agriculture, 100, 5, 5, Resources.RICHSOIL, Resources.POORSOIL, 90, 160),
        ORE("Ore", TechLevel.Medieval, TechLevel.Medieval, TechLevel.Renaissance, 350, 20, 10, Resources.MINERALPOOR, Resources.MINERALRICH, 350, 420),
        GAMES("Games", TechLevel.Renaissance, TechLevel.Agriculture, TechLevel.PostIndustrial, 250, -10, 5, Resources.ARTISTIC, null, 160, 270),
        FIREARMS("Firearms", TechLevel.Renaissance, TechLevel.Agriculture, TechLevel.Industrial, 1250, -75, 100, Resources.WARLIKE, null, 600, 1100),
        MEDICINE("Medicine", TechLevel.EarlyIndustrial, TechLevel.Agriculture, TechLevel.PostIndustrial, 650, -20, 10, Resources.LOTSOFHERBS, null, 400, 700),
        MACHINES("Machines", TechLevel.EarlyIndustrial, TechLevel.Renaissance, TechLevel.Industrial, 900, -30, 5, null, null, 600, 800),
        NARCOTICS("Narcotics", TechLevel.Industrial, TechLevel.PreAgriculture, TechLevel.Industrial, 3500, -125, 150, Resources.WEIRDMUSHROOMS, null, 2000, 3000),
        ROBOTS("Robots", TechLevel.PostIndustrial, TechLevel.EarlyIndustrial, TechLevel.HiTech, 5000, -150, 100, null, null, 3500, 5000);


        private String name;
        private TechLevel mtlp; //minimum tech level to produce good
        private TechLevel mtlu; //minimum tech level to use good
        private TechLevel ttp; //tech level which produces the most of good
        private int base; //base price of good
        private int ipl; //price increase per tech level
        private int var; //maximum percentage that the price can vary above or below the base
        private int mtl; //min price offered in space trade
        private int mth; //max price offered in space trade
        private int quantity;
        private Resources cr; //low-price condition
        private Resources er; //high-price condition
        private int price; //this is the price that was calculated on onEnter in Solarsystem

        GoodsList(String name, TechLevel mtlp, TechLevel mtlu, TechLevel ttp, int base, int ipl, int var, Resources cr, Resources er, int mtl, int mth) {
            this.name = name;
            this.mtlp = mtlp;
            this.mtlu = mtlu;
            this.ttp = ttp;
            this.base = base;
            this.ipl = ipl;
            this.var = var;
            this.cr = cr;
            this.er = er;
            this.mtl = mtl;
            this.mth = mth;
            quantity = 0;
        }
        GoodsList(String name) {
            this.name = name;
        }



        public String getName() {
            return name;
        }

        public TechLevel getMtlp() {
            return mtlp;
        }

        public TechLevel getMtlu() {
            return mtlu;
        }

        public TechLevel getTtp() {
            return ttp;
        }

        public int getBase() {
            return base;
        }

        public int getIpl() {
            return ipl;
        }

        public int getVar() {
            return var;
        }

        public int getMtl() {
            return mtl;
        }

        public int getMth() {
            return mth;
        }

        public int getQuantity() {
            return quantity;
        }

        public Resources getCr() {
            return cr;
        }

        public Resources getEr() {
            return er;
        }

        public int getBasePrice(TechLevel tl) {
            return base + ipl * tl.compareTo(TechLevel.PreAgriculture);
        }

        public void setPrice(int price) {
            this.price = price;
        }
        public int specialResources(Resources resource, int baseprice) {
            if (cr != null) {
                if (resource.equals(cr)) {
                    baseprice *= 3;
                    baseprice /= 4;
                }
            }
            if (er != null) {
                if (resource.equals(er)) {
                    baseprice *= 4;
                    baseprice /= 3;
                }
            }
            return baseprice;
        }


        public int randomizePrice(int baseprice) {
            baseprice += (int) (Math.random() * var);
            baseprice -= (int) (Math.random() * var);
            return baseprice;
        }

        public int sellPrice(int buyprice, int traderskill) {
            return buyprice * (103 + (16 - traderskill)) / 100;
        }

        public boolean canSell(TechLevel soltech) {
            return soltech.compareTo(mtlp) >= 0;
        }

        public int calculateQuantity(TechLevel soltech, int size, Resources resource) {
            int quantity = 9 + ((int) (5 * Math.random())) - Math.abs(ttp.compareTo(soltech)) * (1 + size);
            if (name.equals("Robots") || name.equals("Narcotics")) {
                quantity *= 5;
                quantity /= 6;
                quantity += 1;
            }
            if (resource != null && resource.equals(cr)) {
                quantity *= 4;
                quantity /= 3;
            }
            if (er != null &&resource.equals(er)) {
                quantity *= 3;
                quantity /= 4;
            }

            quantity += (int) (10 * Math.random());
            quantity -= (int) (10 * Math.random());
            if (quantity < 0) {
                quantity = 0;
            }
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getPrice() {
            return price;
        }
    }



