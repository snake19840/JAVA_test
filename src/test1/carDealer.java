package test1;

public class carDealer implements carManufacturer{
    private carManufacturer target;
    public void sellCar(){
        if (target==null)
        {target=new carFactory();}
        target.sellCar();
    }
}
