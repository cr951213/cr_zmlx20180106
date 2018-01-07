package com.example.administrator.cr_zmlx20180106.persenter;

import com.example.administrator.cr_zmlx20180106.view.ICart;
import com.example.administrator.cr_zmlx20180106.bean.CartBean;
import com.example.administrator.cr_zmlx20180106.model.CarModel;
import com.example.administrator.cr_zmlx20180106.net.CGSB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */

public class CartPersenter {
    private ICart iCart;
    private final CarModel cartModel;

    public CartPersenter(ICart iCart) {
        this.iCart = iCart;
        cartModel = new CarModel();

    }
    public void getCart(){
        cartModel.getCart(3043,"android",new CGSB<CartBean>(){

            @Override
            public void chengGong(CartBean cartBean) {
                List<CartBean.DataBean> grouplist = cartBean.getData();
                List<List<CartBean.DataBean.ListBean>> childlist = new ArrayList<>();
                for (int i = 0; i < grouplist.size(); i++) {
                    CartBean.DataBean dataBean = grouplist.get(i);
                    List<CartBean.DataBean.ListBean> list = dataBean.getList();
                    childlist.add(list);
                }
                iCart.showlist(grouplist,childlist);
            }
        });
    }

}
