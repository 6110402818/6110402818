package models;

public class Test {
    public static void main(String[] args) {
        Compartment compartment1 = new Compartment();
        Compartment compartment2 = new Compartment();
        Compartment compartment3 = new Compartment();
        Compartment compartment4= new Compartment();
        Compartment compartment5 = new Compartment();
        Compartment compartment6 = new Compartment();
        FreezingCompartment freezingCompartment1 = new FreezingCompartment();
        FreezingCompartment freezingCompartment2 = new FreezingCompartment();

        Food oreo = new Food("oreo","kanom","shin",20,2,2563,10,false);
        Food mano = new Food("mano","kanom","shin",20,3,2562,5,false);
        Food fas = new Food("fas","kanom","shin",1,3,2561,1,false);




        compartment1.addFood(oreo);
        compartment1.addFood(mano);
        compartment1.addFood(fas);

        System.out.println(compartment1.getFoods());
//        compartment1.sortFood();
//        System.out.println(compartment1.getFoods());


    }
}
