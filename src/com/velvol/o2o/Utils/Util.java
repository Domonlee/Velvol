package com.velvol.o2o.Utils;

import java.util.List;

import android.util.Log;

import com.velvol.o2o.Data;
import com.velvol.o2o.constant.Sell;

/** 基础工具
 * @author Domon 
 */
public class Util {

    /**
     * 
    *  Title: ShowLog 
    *  Description: 打印命令
    *  Modified By：  Domon                                        
    *  Modified Date: 2015-1-8 
    *  @param msg
     */
  	public static void ShowErrorLog(String msg) {
  		Log.e("Domon",msg);
  	}
  	
  	public void addCat(Sell sell){
  		List<Sell> list = Data.getInstance().cat_sell_list;
  		if(list.size() == 0)
  			list.add(sell);
  		else{
  			for (Sell sell_item : list) {
				if(sell.getId()==sell_item.getId()){
					sell.count++;
					return;
				}
			}
  			list.add(sell);
  		}
  	}
}
