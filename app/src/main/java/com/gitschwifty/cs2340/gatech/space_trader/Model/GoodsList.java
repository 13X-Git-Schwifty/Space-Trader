package com.gitschwifty.cs2340.gatech.space_trader.Model;

/**
 *
 */
@SuppressWarnings("ALL")
public enum GoodsList {
    WATER("Water", TechLevel.PRE_AGRICULTURE, TechLevel.PRE_AGRICULTURE, TechLevel.MEDIEVAL, 30, 3, 4, Resources.LOTSOFWATER, Resources.DESERT, 30, 50),
    FURS("Furs", TechLevel.PRE_AGRICULTURE, TechLevel.PRE_AGRICULTURE, TechLevel.PRE_AGRICULTURE, 250, 10, 10, Resources.RICHFAUNA, Resources.LIFELESS, 230, 280),
    FOOD("Food", TechLevel.AGRICULTURE, TechLevel.PRE_AGRICULTURE, TechLevel.AGRICULTURE, 100, 5, 5, Resources.RICHSOIL, Resources.POORSOIL, 90, 160),
    ORE("Ore", TechLevel.MEDIEVAL, TechLevel.MEDIEVAL, TechLevel.RENAISSANCE, 350, 20, 10, Resources.MINERALPOOR, Resources.MINERALRICH, 350, 420),
    GAMES("Games", TechLevel.RENAISSANCE, TechLevel.AGRICULTURE, TechLevel.POST_INDUSTRIAL, 250, -10, 5, Resources.ARTISTIC, null, 160, 270),
    FIREARMS("Firearms", TechLevel.RENAISSANCE, TechLevel.AGRICULTURE, TechLevel.INDUSTRIAL, 1250, -75, 100, Resources.WARLIKE, null, 600, 1100),
    MEDICINE("Medicine", TechLevel.EARLY_INDUSTRIAL, TechLevel.AGRICULTURE, TechLevel.POST_INDUSTRIAL, 650, -20, 10, Resources.LOTSOFHERBS, null, 400, 700),
    MACHINES("Machines", TechLevel.EARLY_INDUSTRIAL, TechLevel.RENAISSANCE, TechLevel.INDUSTRIAL, 900, -30, 5, null, null, 600, 800),
    NARCOTICS("Narcotics", TechLevel.INDUSTRIAL, TechLevel.PRE_AGRICULTURE, TechLevel.INDUSTRIAL, 3500, -125, 150, Resources.WEIRDMUSHROOMS, null, 2000, 3000),
    ROBOTS("Robots", TechLevel.POST_INDUSTRIAL, TechLevel.EARLY_INDUSTRIAL, TechLevel.HI_TECH, 5000, -150, 100, null, null, 3500, 5000);


    private final String name;
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
// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    GoodsList(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)


// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return name
//     */
//    public String getName() {
//        return name;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

    /**
     * @return mtlp
     */
    public TechLevel getMtlp() {
        return mtlp;
    }

    /**
     * @return mtlu
     */
    public TechLevel getMtlu() {
        return mtlu;
    }

    /**
     * @return ttp
     */
    public TechLevel getTtp() {
        return ttp;
    }

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return base
//     */
//    public int getBase() {
//        return base;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return ipl
//     */
//    public int getIpl() {
//        return ipl;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return var
//     */
//    public int getVar() {
//        return var;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return mtl
//     */
//    public int getMtl() {
//        return mtl;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return mth
//     */
//    public int getMth() {
//        return mth;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

    /**
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return cr
//     */
//    public Resources getCr() {
//        return cr;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @return er
//     */
//    public Resources getEr() {
//        return er;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @param tl tag
//     * @return base
//     */
//    public int getBasePrice(TechLevel tl) {
//        return base + ipl * tl.compareTo(TechLevel.PRE_AGRICULTURE);
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

    /**
     * @param price tag
     */
    public void setPrice(int price) {
        this.price = price;
    }

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @param resource tag
//     * @param baseprice tag
//     * @return specialResources
//     */
//    public int specialResources(Resources resource, int baseprice) {
//        if (cr != null) {
//            if (resource.equals(cr)) {
//                baseprice *= 3;
//                baseprice /= 4;
//            }
//        }
//        if (er != null) {
//            if (resource.equals(er)) {
//                baseprice *= 4;
//                baseprice /= 3;
//            }
//        }
//        return baseprice;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)


// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @param baseprice tag
//     * @return randomizePrice
//     */
//    public int randomizePrice(int baseprice) {
//        baseprice += (int) (Math.random() * var);
//        baseprice -= (int) (Math.random() * var);
//        return baseprice;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @param buyprice tag
//     * @param traderskill tag
//     * @return sellPrice
//     */
//    public int sellPrice(int buyprice, int traderskill) {
//        return buyprice * (103 + (16 - traderskill)) / 100;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @param soltech tag
//     * @return canSell
//     */
//    public boolean canSell(TechLevel soltech) {
//        return soltech.compareTo(mtlp) >= 0;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

// --Commented out by Inspection START (4/13/19, 5:16 PM):
//    /**
//     * @param soltech tag
//     * @param size tag
//     * @param resource tag
//     * @return calculateQuantity
//     */
//    public int calculateQuantity(TechLevel soltech, int size, Resources resource) {
//        int quantity = 9 + ((int) (5 * Math.random())) - Math.abs(ttp.compareTo(soltech)) * (1 + size);
//        if (name.equals("Robots") || name.equals("Narcotics")) {
//            quantity *= 5;
//            quantity /= 6;
//            quantity += 1;
//        }
//        if (resource != null && resource.equals(cr)) {
//            quantity *= 4;
//            quantity /= 3;
//        }
//        if (er != null && Objects.requireNonNull(resource).equals(er)) {
//            quantity *= 3;
//            quantity /= 4;
//        }
//
//        quantity += (int) (10 * Math.random());
//        quantity -= (int) (10 * Math.random());
//        if (quantity < 0) {
//            quantity = 0;
//        }
//        return quantity;
//    }
// --Commented out by Inspection STOP (4/13/19, 5:16 PM)

    /**
     * @param quantity tag
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return price
     */
    public int getPrice() {
        return price;
    }

}



