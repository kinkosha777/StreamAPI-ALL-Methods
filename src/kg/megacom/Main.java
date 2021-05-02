package kg.megacom;

import kg.megacom.models.Car;
import kg.megacom.models.Flat;
import kg.megacom.models.Places;
import kg.megacom.models.Tenants;
import kg.megacom.models.enums.CarType;
import kg.megacom.models.enums.ColorCar;
import kg.megacom.models.enums.PlacesType;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        Car car = new Car("Toyota",CarType.SEDAN,ColorCar.WHITE,20000);
        Car car1 = new Car("Mercedes",CarType.JEEP,ColorCar.BLACK,30000);
        Car car2 = new Car("BMW",CarType.SEDAN,ColorCar.BLACK,25000);
        Car car3 = new Car("Honda",CarType.HATCHBACK,ColorCar.SILVER,21000);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);



        ArrayList<Tenants> tenants = new ArrayList<>();
        tenants.add(new Tenants("Бекмырза",23,car,List.of("0704655333")));
        tenants.add(new Tenants("Азамат",22,car1,List.of("0704355443")));
        tenants.add(new Tenants("Жылдызбек",30,car2,List.of("0500443322")));
        tenants.add(new Tenants("Айтурган",32,car3,List.of("0773303285")));
        tenants.add(new Tenants("Айтурган",32,car3,List.of("0773303285")));

        List<Flat> flats = new ArrayList<>();
        flats.add(new Flat(23,3,tenants));
        flats.add(new Flat(24,2,tenants));
        flats.add(new Flat(25,1,tenants));
        flats.add(new Flat(26,3,tenants));


        List<Places> places = new ArrayList<>();
        places.add(new Places("Avangard", PlacesType.EXPENSIVE,flats));
        places.add(new Places("IHLAS", PlacesType.MIDDLE,flats));
        places.add(new Places("Avangard", PlacesType.CLASSIC,flats));
        places.add(new Places("IHLAS", PlacesType.EXPENSIVE,flats));

        System.out.println("==============MapMethod========================================");

        List<PlacesType> mapListToType = places.stream()
                .map(places1 -> places1.getPlacesType())
                .collect(Collectors.toList());
        System.out.println("================================================================");
        System.out.println(mapListToType);


        System.out.println("==========================FlatMap======================================");



        List<String> flatmapToNumber = tenants.stream().map(Tenants::getPhoneNumber).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flatmapToNumber);

        System.out.println("=============================Filter===================================");


        List<Car> PriceOfCars = cars.stream().filter(car4 -> car4.getPrice()<=21000).collect(Collectors.toList());
        System.out.println(PriceOfCars);



        System.out.println("===========================Skip======================================");

        tenants.stream().skip(2).forEach(System.out::println);

        System.out.println("=============================Limit======================================");


        cars.stream().limit(3).forEach(System.out::println);



        System.out.println("===========================Sorted======================================");

        List<Tenants> sortedTenants = tenants.stream()
                .sorted(Comparator.comparing(tenants1 -> tenants1.getName().length())).collect(Collectors.toList());
        System.out.println(sortedTenants);


        System.out.println("==============================Count===================================");

        long total = flats.stream().count();
        System.out.println(total);

        System.out.println("==============================AnyMatch,AllMatch,NoneMatch=====================================");

        boolean match = flats.stream().anyMatch(flat -> flat.getRoom() > 1 );
        boolean match1 = flats.stream().allMatch(flat -> flat.getRoom() < 2 );
        boolean match2 = flats.stream().noneMatch(flat -> flat.getNumber() > 22);

        System.out.println(match);
        System.out.println(match1);
        System.out.println(match2);

        System.out.println("============================FindFirst========================================");

       Optional<Tenants> optionalTenant = tenants.stream().findFirst();
//       Tenants normalTenant = optionalTenant.get();
        boolean tenant1 = optionalTenant.isPresent();
        if(tenant1){
            System.out.println(true);
        }else{
            System.out.println("null");
        }
//        System.out.println(normalTenant);
        System.out.println("==============================FindAny=========================================");
        Optional<Tenants> OptionalTenant = tenants.stream().findAny();
        boolean  tenant2 = optionalTenant.isPresent();
        if(tenant2){
            System.out.println(true);
        }else {
            System.out.println("null");
        }
//        Tenants middleTenant = OptionalTenant.get();
//        System.out.println(middleTenant);

        System.out.println("=======================================================================");

        Comparator ageComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        System.out.println("=============================Max=========================================");

       Optional<Tenants> oldestTenant = tenants.stream().max(Comparator.comparingInt(Tenants::getAge));
        Tenants oldestPeople = oldestTenant.get();
        System.out.println(oldestPeople);

        System.out.println("=============================Min=========================================");

        Optional<Tenants> youngestTenant = tenants.stream().min(Comparator.comparingInt(Tenants::getAge));
        Tenants youngestPeople = youngestTenant.get();
        System.out.println(youngestPeople);

        System.out.println("==============================Reduce==============================================");


       Optional<Integer> carsReduce = cars.stream().map(Car->Car.getPrice()).reduce((Car, Cars)->Car+Cars);


        System.out.println("reduce == "+carsReduce);

        System.out.println("================================Distinct==============================================");



      List<String> distinctPlaces = places.stream().map(Places::getName).distinct().collect(Collectors.toList());
        System.out.println(distinctPlaces);



        System.out.println("======================================Peek=================================================");


          cars.stream()
                  .peek(x-> System.out.println("peek before distinct = "+x))
                  .distinct()
                  .peek(x-> System.out.println("peek after distinct = "+x))
                  .filter(car4 -> car4.getPrice()>= 30000)
                  .peek(x-> System.out.println("peek after distinct,filter = "+x))
                  .forEach(x-> System.out.println("Foreach = "+x));





    }


}
