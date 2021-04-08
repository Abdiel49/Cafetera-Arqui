package UI.gui;

import Cafetera.Cafetera;
import Enums.CoffeeType;
import Events.EventTypes;

public class ActionsContainer extends Container {

    private ActionStatusButton coffeeMakerStatus;
    private ActionStatusButton giveCoffeeStatus;
    private ActionStatusButton loadWater;
    private ActionStatusButton loadCoffee;
    private ActionStatusButton borraStatus;

    private final Cafetera coffeemaker;
    private boolean switchOnOff;

    public  ActionsContainer(Cafetera coffeemaker){
        this.coffeemaker = coffeemaker;
        this.switchOnOff = false;
        initComponent();
        this.setVisible(true);
    }

    private void initComponent(){
        coffeeMakerStatus = new ActionStatusButton("CAFETERA", false);
        giveCoffeeStatus  = new ActionStatusButton("SERVIR CAFE", true);
        borraStatus       = new ActionStatusButton("VACIAR BORRA",false);
        loadCoffee        = new ActionStatusButton("CARGAR CAFE", true );
        loadWater         = new ActionStatusButton("CARGAR AGUA", true);
        addActions();
        this.add(coffeeMakerStatus);
        this.add(loadWater);
        this.add(loadCoffee);
        this.add(borraStatus);
        this.add(giveCoffeeStatus);
    }

    private void addActions(){
        coffeeMakerStatus.addActionListener(e -> switchOnOff());
        giveCoffeeStatus.addActionListener (e -> giveMeCoffee());
        borraStatus.addActionListener      (e -> emptyBorra());
        loadCoffee.addActionListener       (e -> loadCoffee());
        loadWater.addActionListener        (e -> loadWater());
    }

    private void switchOnOff(){
        this.switchOnOff = coffeemaker.turnOnOff();
    }

    private void loadCoffee(){
        coffeemaker.loadCoffee();
    }

    private void loadWater(){
        coffeemaker.loadWater();
    }

    private void giveMeCoffee(){
        if(switchOnOff){
            coffeemaker.giveACoffee(CoffeeType.COFFEE);
        }
    }

    private void emptyBorra(){
        if(switchOnOff){
            coffeemaker.emptyBorra();
        }
    }

    public void updateData(EventTypes event){
        switch (event){
            case BORRA_EMPTIED -> borraStatus.changeColorState(Colors.INACTIVE);
            case BORRA_FILLED  -> borraStatus.changeColorState(Colors.ERROR);
            case SUCCESSFULLY  -> giveCoffeeStatus.changeColorState(Colors.SUCCESS);
            case UN_SUCCESS    -> giveCoffeeStatus.changeColorState(Colors.ERROR);
            case TURN_ON       -> coffeeMakerStatus.changeColorState(Colors.SUCCESS);
            case TURN_OFF      -> coffeeMakerStatus.changeColorState(Colors.INACTIVE);
        }
    }
}
