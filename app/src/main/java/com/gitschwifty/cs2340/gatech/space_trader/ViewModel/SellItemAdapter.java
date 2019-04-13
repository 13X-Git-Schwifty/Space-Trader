
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
        import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;

        import java.util.ArrayList;
        import java.util.List;

/**
 * SellItemAdapter
 */
@SuppressWarnings("ALL")
public class SellItemAdapter extends RecyclerView.Adapter<SellItemAdapter.BuyItemViewHolder>{
     private static final String TAG = "RecyclerViewAdapter_SellItem";

    

     private final List<String> CargoItems;
    private final ArrayList<Integer> CargoItemPrice;
    private final Context mContext;
    private final Player player = LoginActivity.getNewPlayer();


    /**
     * @param CargoItems tag
     * @param CargoItemPrice tag
     * @param mContext tag
     */
    public SellItemAdapter(List<String> CargoItems, ArrayList<Integer> CargoItemPrice,
                           Context mContext) {
        this.CargoItems = CargoItems;
        this.CargoItemPrice = CargoItemPrice;
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
    public void onBindViewHolder(@NonNull final BuyItemViewHolder holder, final int i)
            throws NullPointerException {
        Log.d("hello", "onBindViewHolder: called.") ;
        holder.buyItemName.setText(CargoItems.toString());
        holder.buyItemPrice.setText(CargoItemPrice.get(i).toString());

        holder.buyItemLayout.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                if (CargoItemPrice.get(i) == 0) {
                    Toast.makeText(mContext, CargoItems.get(i) + " is unavailable to sell.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        if (i >= CargoItems.size()) {
                            sell(CargoItems.get(0));
                            Toast.makeText(mContext, "Item sold! Your credit score is now: " +
                                    LoginActivity.getNewPlayer().getCreditScore(),
                                    Toast.LENGTH_SHORT).show();
//                            LoginActivity.getNewPlayer().removeFromPlayerGoods(Cargoitems.get(0));
                            CargoItems.remove(holder.getAdapterPosition());
                            notifyItemRemoved(holder.getAdapterPosition());
                            notifyItemRangeChanged(holder.getAdapterPosition(),CargoItems.size());
                        } else {
                            GoodsList good = GoodsList.valueOf(CargoItems.get(i));
                            sell(CargoItems.get(i));
                            Toast.makeText(mContext, "Item sold! Your credit score is now: " +
                                    LoginActivity.getNewPlayer().getCreditScore(),
                                    Toast.LENGTH_SHORT).show();
//                            LoginActivity.getNewPlayer().removeFromPlayerGoods(CargoItems.get(i));
                            CargoItems.remove(holder.getAdapterPosition());
                            notifyItemRemoved(holder.getAdapterPosition());
                            notifyItemRangeChanged(holder.getAdapterPosition(), CargoItems.size());
                        }
                    } catch (NullPointerException e) {
                        sell(CargoItems.get(0));
                        Toast.makeText(mContext, "Item sold! Your credit score is now: "
                                + LoginActivity.getNewPlayer().getCreditScore(),
                                Toast.LENGTH_SHORT).show();
//                        LoginActivity.getNewPlayer().removeFromPlayerGoods(Cargoitems.get(0));
                        CargoItems.remove(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());
                        notifyItemRangeChanged(holder.getAdapterPosition(),CargoItems.size());
                    }
                    }

            }
            });


    }

    @Override
    public int getItemCount() {
        return CargoItems.size();
    }

    /**
     * @param good tag
     * @return canSell
     */
    //can sell
    public boolean canSell(GoodsList good) {
        return true;
    }


    //the selling process
    private void sell(String goodie) {
        GoodsList goods = GoodsList.valueOf(goodie);
        this.player.setCreditScore(player.getCreditScore() + goods.getPrice());
        goods.setQuantity(goods.getQuantity() - 1);
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
