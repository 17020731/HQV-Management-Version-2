package BackEnd;

import Database.DataClass;

import java.io.*;
import java.util.ArrayList;

public class Management {
    private ArrayList<Vangta>vangtas = new ArrayList<>();
    private ArrayList<Vangtay>vangtays = new ArrayList<>();
    private ArrayList<Currency>currencies = new ArrayList<>();


    public Management(){
        init();
    }


    //todo: Hàm khởi tạo lấy dữ liệu từ tệp (thông tin path và name của sản phẩm vàngta-vàngtây-ngoạitệ
    public void init(){
        initVangtaProduct(vangtas, "SELECT * FROM products WHERE productCode LIKE 'GTA%';");
        initVangtayProduct(vangtays, "SELECT * FROM products WHERE productCode LIKE 'GTY%';");
        initCurrencyProduct(currencies, "SELECT * FROM products WHERE productCode LIKE 'NGT%';");
    }

    //todo:Lấy data sản phẩm Vàng ta
    public void initVangtaProduct(ArrayList<Vangta>vangta, String que){
        DataClass data = new DataClass();
//        data.getRequest();
        ArrayList<ArrayList<Object>> arr = data.getRequest(que, 5);
        for(ArrayList<Object> ar : arr){
            Vangta vangta1 = new Vangta();
            vangta1.setPath(ar.get(2).toString());
            vangta1.setName(ar.get(1).toString());
            vangta.add(vangta1);
        }
    }

    //todo: Lấy data sản phẩm Vàng tây
    public void initVangtayProduct(ArrayList<Vangtay>vangtay, String que){
        DataClass data = new DataClass();
        ArrayList<ArrayList<Object>> arr = data.getRequest(que, 5);
        for(ArrayList<Object> ar : arr){
            Vangtay vangtay1 = new Vangtay();
            vangtay1.setPath(ar.get(2).toString());
            vangtay1.setName(ar.get(1).toString());
            vangtay.add(vangtay1);
        }
    }

    //todo: Lấy data sản phẩm Ngoại tệ
    public void initCurrencyProduct(ArrayList<Currency>currencies, String que){
        DataClass data = new DataClass();
        ArrayList<ArrayList<Object>> arr = data.getRequest(que, 5);
        for(ArrayList<Object> ar : arr){
            Currency currency = new Currency();
            currency.setPath(ar.get(2).toString());
            currency.setName(ar.get(1).toString());
            currencies.add(currency);
        }
    }


    public ArrayList<Vangta> getVangtas() {
        return vangtas;
    }

    public void setVangtas(ArrayList<Vangta> vangtas) {
        this.vangtas = vangtas;
    }

    public ArrayList<Vangtay> getVangtays() {
        return vangtays;
    }

    public void setVangtays(ArrayList<Vangtay> vangtays) {
        this.vangtays = vangtays;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }
}
