
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
        import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;
        import com.gitschwifty.cs2340.gatech.space_trader.ViewModel.BuyItemAdapter;

        import java.util.ArrayList;

public class SellItemAdapter extends RecyclerView.Adapter<SellItemAdapter.BuyItemViewHolder>{
    private static final String TAG = "RecyclerViewAdapter_SellItem";

    

     ArrayList<String> Cargoitems;
    ArrayList<Integer> Cargoitemprice;
    private Context mContext;

    public SellItemAdapter(ArrayList<String> Cargoitems, ArrayList<Integer> Cargoitemprice, Context mContext) {
        this.Cargoitems = Cargoitems;
        this.Cargoitemprice = Cargoitemprice;
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
        Log.d("hello", "onBindViewHolder: called.") ;
        holder.buyItemName.setText(Cargoitems.get(i));
        holder.buyItemPrice.setText(Cargoitemprice.get(i).toString());

        holder.buyItemLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (Cargoitemprice.get(i) == 0) {
                    Toast.makeText(mContext, Cargoitems.get(i) + " is unavailable to sell.", Toast.LENGTH_SHORT).show();
                }
                else {
                    GoodsList good = GoodsList.valueOf(Cargoitems.get(i));
                    good.setPrice(0);
                        LoginActivity.getNewPlayer().sell(Cargoitems.get(i));
                        Toast.makeText(mContext, "Your credit score is now: " + LoginActivity.getNewPlayer().getCreditScore(), Toast.LENGTH_SHORT).show();
                    }
            }
            });


    }

    @Override
    public int getItemCount() {
        return Cargoitems.size();
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