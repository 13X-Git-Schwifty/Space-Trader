package com.gitschwifty.cs2340.gatech.space_trader.ViewModel;

import android.annotation.SuppressLint;
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
import com.gitschwifty.cs2340.gatech.space_trader.Model.Player;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.View.BuyItem;
import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BuyItemAdapter
 */
@SuppressWarnings("ALL")
public class BuyItemAdapter extends RecyclerView.Adapter<BuyItemAdapter.BuyItemViewHolder>{
    private static final String TAG = "RecyclerViewAdapter_Buy";
    private static final int CARGO_CAPACITY = 20;

    private final List<String> mItemNames;

    /**
     * @return CargoItems
     */
    public static List<String> getCargoItems() {
        return Collections.unmodifiableList(CargoItems);
    }

    private static final List<String> CargoItems = new ArrayList<>(CARGO_CAPACITY);

    /**
     * @return CargoItemPrice
     */
    public static List<Integer> getCargoItemPrice() {
        return Collections.unmodifiableList(CargoItemPrice);
    }

    private static final List<Integer> CargoItemPrice = new ArrayList<>();

    private final ArrayList<Integer> mItemPrices;
    private final Context mContext;
    private final Player player = LoginActivity.getNewPlayer();

    /**
     * @param mItemNames tag
     * @param mItemPrices tag
     * @param mContext tag
     */
    public BuyItemAdapter(List<String> mItemNames, ArrayList<Integer> mItemPrices,
                          Context mContext) {
        this.mItemNames = mItemNames;
        this.mItemPrices = mItemPrices;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BuyItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_buy_item,
                viewGroup, false)   ;
        return new BuyItemViewHolder(view);
    }

    @SuppressLint({"RecyclerView", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull BuyItemViewHolder holder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.") ;
        holder.buyItemName.setText(mItemNames.get(i));
        holder.buyItemPrice.setText(mItemPrices.get(i).toString());
        holder.buyItemLayout.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (mItemPrices.get(i) == 0) {
                    Log.d(TAG, "onClick: clicked on:" + mItemNames.get(i) + " and " +
                            mItemPrices.get(i));
                    Toast.makeText(mContext, mItemNames.get(i) + " is unavailable.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    GoodsList good = GoodsList.valueOf(mItemNames.get(i));
                    CargoItems.add(mItemNames.get(i));
                    CargoItemPrice.add(mItemPrices.get(i));
                    good.setPrice(mItemPrices.get(i));
                    if (!canBuy(good)){
                        Toast.makeText(mContext, "Not enough cargo capacity.",
                                Toast.LENGTH_SHORT).show();
                    } else if (mItemPrices.get(i) > player.getCreditScore())     {
                         Toast.makeText(mContext, "Not enough credits",
                                 Toast.LENGTH_SHORT).show();
                    } else {
                      buy(mItemNames.get(i));
                      Toast.makeText(mContext, "Your credit score is now: " +
                              LoginActivity.getNewPlayer().getCreditScore(),
                              Toast.LENGTH_SHORT).show();

                        //update Info
                        // creditScore
                        TextView creditScoreTV = ((BuyItem)mContext).
                                findViewById(R.id.creditScoreDisplay);
                        creditScoreTV.setText("Your credit score is: " +
                                LoginActivity.getNewPlayer().getCreditScore());
                        //cargo space
                        TextView cargoSpaceTV = ((BuyItem)mContext).
                                findViewById(R.id.cargoSpaceDisplay);
                        cargoSpaceTV.setText("Remaining cargo space is " +
                                (CARGO_CAPACITY - getCargoItems().size()));
//                        player.addToPlayerGoods(good);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemNames.size();
    }

    //can buy
    private boolean canBuy(GoodsList good) {
//        if (player.getPlayerGoods().size() + 1 > 20) {
//            return false;
//        } else if (this.player.getCreditScore() <= 0) {
//            return false;
//        } else
//        {
//            return true;
//        }
        return true;
    }
    //the buying process
    private void buy(String goodz) {
        GoodsList good = GoodsList.valueOf(goodz);
        if (!canBuy(good)) {
            return;
        } else {
            this.player.setCreditScore(player.getCreditScore() - good.getPrice());
//            player.addToPlayerGoods(good);
        }
        good.setQuantity(good.getQuantity() + 1);
    }


    public class BuyItemViewHolder extends RecyclerView.ViewHolder {

            final TextView buyItemName;
            final TextView buyItemPrice;
            final RelativeLayout buyItemLayout;

            BuyItemViewHolder(@NonNull View itemView) {
                super(itemView);
                buyItemName = itemView.findViewById(R.id.itemName);
                buyItemPrice = itemView.findViewById(R.id.itemPrice);
                buyItemLayout = itemView.findViewById(R.id.layout_buy_item);
            }
    }
}
