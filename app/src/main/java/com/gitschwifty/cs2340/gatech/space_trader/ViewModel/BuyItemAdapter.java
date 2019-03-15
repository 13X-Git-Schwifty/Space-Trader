package com.gitschwifty.cs2340.gatech.space_trader.ViewModel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.GoodsList;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.View.BuyItem;
import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;

import java.util.ArrayList;

public class BuyItemAdapter extends RecyclerView.Adapter<BuyItemAdapter.BuyItemViewHolder>{
    private static final String TAG = "RecyclerViewAdapter_BuyItem";

    private ArrayList<String> mItemNames = new ArrayList<>();

    public static ArrayList<String> getCargoitems() {
        return Cargoitems;
    }

    private static ArrayList<String> Cargoitems = new ArrayList<>(20);

    public static ArrayList<Integer> getCargoitemprice() {
        return Cargoitemprice;
    }

    private static ArrayList<Integer> Cargoitemprice = new ArrayList<>();

    private ArrayList<Integer> mItemPrices = new ArrayList<>();
    private Context mContext;

    public BuyItemAdapter(ArrayList<String> mItemNames, ArrayList<Integer> mItemPrices, Context mContext) {
        this.mItemNames = mItemNames;
        this.mItemPrices = mItemPrices;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BuyItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_buy_item, viewGroup, false)   ;
        BuyItemViewHolder holder = new BuyItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BuyItemViewHolder holder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.") ;
        holder.buyItemName.setText(mItemNames.get(i));
        holder.buyItemPrice.setText(mItemPrices.get(i).toString());
        holder.buyItemLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mItemPrices.get(i) == 0) {
                    Log.d(TAG, "onClick: clicked on:" + mItemNames.get(i) + " and " + mItemPrices.get(i));
                    Toast.makeText(mContext, mItemNames.get(i) + " is unavailable.", Toast.LENGTH_SHORT).show();
                } else {
                    GoodsList good = GoodsList.valueOf(mItemNames.get(i));

                    Cargoitems.add(mItemNames.get(i));
                    Cargoitemprice.add(mItemPrices.get(i));
                    good.setPrice(mItemPrices.get(i));
                    LoginActivity.getNewPlayer().addToPlayerGoods(mItemNames.get(i));
                    if (LoginActivity.getNewPlayer().canBuy(good) == false){
                        Toast.makeText(mContext, "Not enough cargo capacity.", Toast.LENGTH_SHORT).show();
                    } else if (mItemPrices.get(i) > LoginActivity.getNewPlayer().getCreditScore())     {
                         Toast.makeText(mContext, "Not enough credits", Toast.LENGTH_SHORT).show();
                    } else {
                      LoginActivity.getNewPlayer().buy(mItemNames.get(i));
                      Toast.makeText(mContext, "Your credit score is now: " + LoginActivity.getNewPlayer().getCreditScore(), Toast.LENGTH_SHORT).show();

                      //update Info
                      //creditScore
                        TextView creditScoreTV = ((BuyItem)mContext).findViewById(R.id.creditScoreDisplay);
                        creditScoreTV.setText("Your credit score is: " + LoginActivity.getNewPlayer().getCreditScore());
                        //cargo space
                        TextView cargoSpaceTV = ((BuyItem)mContext).findViewById(R.id.cargoSpaceDisplay);
                        cargoSpaceTV.setText("Remaining cargo space is " + (20 - getCargoitems().size()));
                    }

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemNames.size();
    }

    public class BuyItemViewHolder extends RecyclerView.ViewHolder {

            TextView buyItemName;
            TextView buyItemPrice;
            RelativeLayout buyItemLayout;

            public BuyItemViewHolder(@NonNull View itemView) {
                super(itemView);
                buyItemName = itemView.findViewById(R.id.itemName);
                buyItemPrice = itemView.findViewById(R.id.itemPrice);
                buyItemLayout = itemView.findViewById(R.id.layout_buy_item);
            }


}
}
