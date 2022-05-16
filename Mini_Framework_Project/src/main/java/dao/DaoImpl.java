package dao;

import InjectionAnotation.AmComponent;
@AmComponent
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("DaoImpl Version 1");
        double temp=Math.random()*40;
        return temp;
    }
}
