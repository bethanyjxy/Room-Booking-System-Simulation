import java.util.*;

class Promo
{
    private String name;
    private int discount, minSpend;

    Promo (String name, int discount, int minSpend)
    {
        this.name = name;
        this.discount = discount;
        this.minSpend = minSpend;
        
    }

    public String getPromoName()
    {
        return name;
    }

    public int getDiscount()
    {
        return discount;
    }

    public int getMinSpend()
    {
        return minSpend;
    }

    public String toString()
    {
        return String.format("Promo Code Name: %s, %d%s Off with Min Spending of $%d", name, discount, "%", minSpend);
    }
}

class Room
{
    private String name;
    private int cap, from, till, price;
    private Boolean avail;

    Room(String name, int cap, Boolean avail, int from, int till, int price)
    {
        this.name =  name;
        setCap(cap);
        setAvail(avail);
        setFrom(from);
        setTill(till);
        setPrice(price);
    }

    public String getName()
    {
        return name;
    }

    public int getCap()
    {
        return cap;
    }

    public int getFrom()
    {
        return from;
    }

    public int getTill()
    {
        return till;
    }

    public int getPrice()
    {
        return price;
    }

    public Boolean getAvail()
    {
        return avail;
    }

    public void setCap(int cap)
    {
        this.cap = cap;
    }

    public void setAvail(Boolean avail)
    {
        this.avail = avail;
    }

    public void setFrom(int from)
    {
        this.from = from;
    }

    public void setTill(int till)
    {
        this.till = till;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

}

class Booking
{
    String name, stuName;
    int cap,from,till, bookID, minFrom, maxTill;
    double price, roomCost;

    //Booking ID, Student name , Room Name, Capacity, Price Paid , (Book slot) From , Till, (Slot orignally available) from, till, cost of room per hr 
    Booking(int bookID, String stuName, String name, int cap, double price, int from, int till, int minFrom, int maxTill, double roomCost)
    {
        this.bookID = bookID;
        this.name = name;
        this.stuName = stuName;
        this.cap = cap;
        setPrice(price);
        setFrom(from);
        setTill(till);
        this.minFrom = minFrom;
        this.maxTill = maxTill;
        this.roomCost = roomCost;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setFrom(int from)
    {
        this.from = from;
    }

    public void setTill(int till)
    {
        this.till = till;
    }

    public int getbookID()
    {
        return bookID;
    }

    public int getHour()
    {
        return (till-from)/100 ;
    }

    public double getPrice()
    {
        return price;
    }

    public int getFrom()
    {
        return from;
    }

    public int getTill()
    {
        return till;
    }

    public String getName()
    {
        return name;
    }

    public String getStuName()
    {
        return stuName;
    }

    public int getCap()
    {
        return cap;
    }

    public int getMaxTill()
    {
        return maxTill;
    }

    public int getMinFrom()
    {
        return minFrom;
    }

    //Room cost per hour
    public Double getRoomCost()
    {
        return roomCost;
    }
    public String toString()
    {
        return String.format("%-10s %-10s %-10s %-10s \t %04d \t %04d \t %-5s\n",
                            String.valueOf(getbookID()),getStuName(), getName(), String.valueOf(getCap()), getFrom(), getTill(), 
                            String.valueOf("$" + getPrice()));
    }
}


class RBS
{
    private static final String line = "\n------------------------------------------\n";

    private static List <Room> roomList = new ArrayList <Room>();
    private static List <Booking> bookList = new ArrayList <Booking>();
    private static List <Promo> promoList = new ArrayList <Promo>();

    private static Scanner input = new Scanner(System.in);
    private static int entry;

    private static double getAfterDiscount(double before, double discount)
    {
        return(before * ((100.0-discount)/100.0));
    }

    //Returns a random student name
    private static String randomStudent()
    {
        String [] student = {"Mary", "John", "Ken", "Lily","Susan","Tom"};
        int num = (int)(Math.random()* student.length);
        return student[num];
    }

    // Add some promo code and room creation 
    private static void importRoomPromo()
    {
        String [] name = {"A2L14","B1L23","C3L34","D3L45","E4L12","F4L22","G5L46"};
        int [] capacity = {10, 20, 15, 10, 10, 15, 20};
        Boolean [] avail = {true, false, true, false, true, true, true};
        int [] from = {1100, 900, 1000, 900, 900, 1200, 800};
        int [] till = {1700, 1500, 1600, 1700, 1800, 1900, 1700};
        int [] price = {10, 15, 20, 15, 5, 10, 15};
        String [] promo = {"5OFF" ,"10OFF" };
        int [] discount = {5,10};
        int [] minSpend = {30, 50};


        for(int i=0 ; i < name.length; i++ )
        {
            roomList.add(new Room(name[i], capacity[i], avail[i], from[i], till[i],price[i]));
        }

        promoList.add(new Promo(promo[0], discount[0], minSpend[0]));
        promoList.add(new Promo(promo[1], discount[1], minSpend[1]));

        System.out.println("\nSuccessfully imported Rooms and Promo Codes");
    }

    //Teachers Menu
    private static void createRoom () //Clock format : 24h
    {
        System.out.println(line);

        Boolean avail = false;
        String name = "";
        do
        {
            System.out.println("\nCreate Room");
            input.nextLine();
            System.out.print("Room name: ");
            name = input.nextLine();
            System.out.print("\nCapacity: ");
            int capacity = input.nextInt();
            input.nextLine();
            System.out.print("\nAvailable Y/N: ");
            char yn = input.next().charAt(0);
            input.nextLine();
            System.out.print("\nFrom: ");
            int from = input.nextInt();
            input.nextLine();
            System.out.print("\nTill: ");
            int till = input.nextInt();
            input.nextLine();
            System.out.print("\nPrice: ");
            int price = input.nextInt();
            input.nextLine();

            if(yn == 'Y' || yn =='y')
            {
                avail = true;
            }
            else
                avail = false;

            roomList.add(new Room (name, capacity, avail, from, till, price));

            System.out.println("\nEnter 1 to create another room, Enter 9 to exit : ");
            entry = input.nextInt();
            input.nextLine();
            
        }while (entry != 9);
    }

    //Available / Not available
    private static void launchRoom()
    {
        Boolean avail;

        do
        {
        System.out.print("Enter number: ");
        int num = input.nextInt();
        input.nextLine();
        System.out.print("\nAvailable Y/N: ");
        char yn = input.next().charAt(0);
        
        if(yn == 'Y' || yn =='y')
            avail = true;
        else
            avail = false;

        roomList.get(num-1).setAvail(avail);
        System.out.println("Change Successful\n");
        printList();
        System.out.println("\nEnter 1 modify again, Enter 9 to exit : ");
        entry = input.nextInt();
        input.nextLine();
        } while (entry != 9);
    }

    private static void adjustPrice()
    {
        do
        {
            System.out.print("Enter number: ");
            int num = input.nextInt();
            input.nextLine();
            System.out.print("\nEnter the price: ");
            int price = input.nextInt();
            roomList.get(num-1).setPrice(price);
            System.out.println("Change Successful\n");
            printList();
            System.out.println("\nEnter 1 modify again, Enter 9 to exit : ");
            entry = input.nextInt();
            input.nextLine();
        } while (entry != 9);
    }

    //From & Till (24h clock format)
    private static void adjustTime()
    {
        do
        {
            System.out.print("Enter number: ");
            int num = input.nextInt();
            input.nextLine();
            System.out.print("\nFrom: ");
            int from = input.nextInt();
            input.nextLine();
            System.out.print("\nTill: ");
            int till = input.nextInt();
            input.nextLine();

            roomList.get(num-1).setFrom(from);
            roomList.get(num-1).setTill(till);
            System.out.println("Change Successful\n");
            printList();
            System.out.println("\nEnter 1 modify again, Enter 9 to exit : ");
            entry = input.nextInt();
            input.nextLine();
        } while (entry != 9);
    }

    private static void adjustCapacity()
    {
        do
        {
            System.out.print("Enter number: ");
            int num = input.nextInt();
            input.nextLine();
            System.out.print("\n Capacity: ");
            int cap = input.nextInt();
            input.nextLine();
            roomList.get(num-1).setCap(cap);
            System.out.println("Change Successful\n");
            printList();
            System.out.println("\nEnter 1 modify again, Enter 9 to exit : ");
            entry = input.nextInt();
            input.nextLine();
        } while (entry != 9);
    }

    private static void adjustPromo()
    {
        System.out.println(line);
        System.out.println("\n1: Add Promo\n");
		System.out.println("2: Delete Promo\n");
		System.out.println("3: View Promo\n");
        System.out.println("9: Exit\n");
        System.out.print("Your option: ");
        entry= input.nextInt();
        input.nextLine();

        if(entry == 1)
        {
            System.out.println(line);
            System.out.print("Enter Promo code name: ");
            String promo = input.nextLine();
            System.out.print("Enter discount (%): ");
            int discount = input.nextInt();
            input.nextLine();
            System.out.print("Min Spending: ");
            int minSpend = input.nextInt();
            input.nextLine();


            promoList.add(new Promo(promo, discount, minSpend)); 

            for(int i = 0 ; i < promoList.size(); i++)
            {
                if(promo.equals(promoList.get(i).getPromoName()))
                System.out.printf("\nPromo Code added: %s, %d%s Off with Min Spending of $%d",
                                    promoList.get(i).getPromoName(), promoList.get(i).getDiscount(),"%", promoList.get(i).getMinSpend());
            }
        }
        else if(entry == 2)
        {
            System.out.println(line);
            for(int i = 0 ; i < promoList.size() ; i++)
            {
                System.out.print((i+1) + ". ");
                System.out.println(promoList.get(i));
            }

            System.out.print("Select Promo Code to remove: ");
            int enter = input.nextInt();

            promoList.remove(enter-1);
            
            System.out.println("Promo Code is deleted");
        }
        else if(entry == 3)
        {
            if (promoList.isEmpty())
                System.out.println("\nNo active Promo Code"); 
            else
            {
                System.out.println(line);
                System.out.println("Current Active Promo Code");

                for(int i =0 ; i < promoList.size(); i++)
                {
                    System.out.println(promoList.get(i).toString());
                }
            }       
        }
        else if (entry == 9)
        {
            System.out.println();
        }
        else
        {
            System.out.println("\nPlease enter a valid option.");
        }
    }


//STUDENT MENU
    private static void makeBook(String student)
    {
        Boolean check, promoInvalid;
        int hours, user, discount, from, till, valid;
        double beforePrice, afterPrice, roomCost;
        String promoName;
        check = false;
        promoInvalid = true;
        user = 0;
        afterPrice = 0.0;
        discount = 0;
        promoName = "";
        roomCost = 0.0;
        valid = 0;
        int bookingID = (int)(Math.random()*100);

        do
        {
            printRoom();
            System.out.print("Enter number: ");
            int num = input.nextInt();
            input.nextLine();

            do{
                System.out.print("\nBooking Time (From): ");
                from = input.nextInt();
                input.nextLine();
                System.out.print("\nTotal Hours: ");
                hours = input.nextInt();
                input.nextLine();

                till = (hours * 100) + from;

                //If the student chooses time not given in the time slot available
                if((from < roomList.get(num-1).getFrom())||(till > roomList.get(num-1).getTill()))
                {
                    check = false;
                    System.out.println("\nInvalid, please enter the time within the available period");
                }
                else
                    check = true;
            } while(check != true);
            
            System.out.print("Enter 1 to Apply Promo Code, Enter other numbers to Skip: ");
            user = input.nextInt();
            input.nextLine();

            //Calculates the timing and the total price
            roomCost = roomList.get(num-1).getPrice();
            beforePrice = hours * roomCost;

            if(user == 1)
            {
                do
                {
                    System.out.println("\nEnter Promo Code: ");
                    promoName = input.nextLine();
                    for(int i = 0 ; i < promoList.size(); i++)
                    {
                        //If promocode does not hit the min spending
                        if(promoName.equals(String.valueOf(promoList.get(i).getPromoName())))
                        {
                            if(beforePrice >= promoList.get(i).getMinSpend())
                            {
                                System.out.println("Promo Code Successfully Applied");
                                discount = promoList.get(i).getDiscount();
                                promoInvalid = false;
                                valid = 1;
                                user = 2;
                            }
                            else
                            {
                                System.out.println("\nInvalid, Please spend a min of $"+promoList.get(i).getMinSpend()+" to use this code");
                                user = 2;
                            }

                        }
                    }
                        if((promoInvalid == true )&& (user != 2)) 
                        {
                            System.out.println("\nPromo Code does not exist.");
                        }
                        //Chooses not to add in promo code 
                        if(user != 2)
                        {
                            System.out.print("Enter 1 to Apply Promo Code, Enter 2 to Skip: ");
                            user = input.nextInt();
                            input.nextLine();
                        }
                } while (user != 2);
            }

            
            

            //If promo is applied succuessfully
            if (valid == 1)
            {
                printReciept(hours, promoName, beforePrice, discount, from, till, true);
                System.out.print("Confirm Booking, Y/N: ");
                char yn = input.next().charAt(0);
                input.nextLine();

                if((yn == 'y' || yn == 'Y'))
                {

                    afterPrice = getAfterDiscount(beforePrice, discount);

                    System.out.println("\nBooking is Successful.");
                    System.out.println("Your Booking ID is " + bookingID);
                    bookList.add(new Booking(bookingID, student ,roomList.get(num-1).getName(),roomList.get(num-1).getCap(),
                                            afterPrice, from, till,   
                    roomList.get(num-1).getFrom(), roomList.get(num-1).getTill(), roomCost));
                    
                    roomList.get(num-1).setAvail(false);
                    entry = 9;
                }
                else
                {
                    System.out.println("\nBooking Unsuccessful");
                    entry = 9;
                }     
            }

            //No Promo code is added
            else
            {
                printReciept(hours, promoName , beforePrice, 0, from, till, false);
                System.out.print("Confirm Booking, Y/N: ");
                char yn = input.next().charAt(0);
                input.nextLine();

                if((yn == 'y' || yn == 'Y'))
                {
                    System.out.println("\nBooking is Successful.");
                    System.out.println("Your Booking ID is " + bookingID);
                    bookList.add(new Booking(bookingID , student ,roomList.get(num-1).getName(),roomList.get(num-1).getCap(),
                                    beforePrice, from, till,
                                    roomList.get(num-1).getFrom(), roomList.get(num-1).getTill(), roomCost));
                    roomList.get(num-1).setAvail(false);
                    entry = 9;
                }
                else
                {
                    System.out.println("\nBooking Unsuccessful");
                    entry = 9;
                }     
            }

        } while (entry != 9);
    }

    private static void modifyBook(String student)
    {
        Boolean check = false;
        double updateNewCost = 0.0;
        int bookID = 0;
        int till = 0;
        entry = 0;
        int from = 0;
        int hour = 0;
        int x = 0;
        System.out.println(line);
        
        do
        {
            printBook(student);
            System.out.print("\nEnter Booking ID number: ");
            bookID = input.nextInt();
            input.nextLine();

            for(int i = 0 ; i < bookList.size() ; i++)
            {
                if(bookID == bookList.get(i).getbookID())
                {
                    System.out.println("\nPlease enter in this time slot available, From: " + bookList.get(i).getMinFrom() + " Till: " + bookList.get(i).getMaxTill() + " Max Hours: " 
                                        + ((bookList.get(i).getMaxTill()-bookList.get(i).getMinFrom())/100));
                    System.out.println("\nEnter the time (From): ");
                    from = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the hours: ");
                    hour = input.nextInt();
                    input.nextLine();
                    
                    till = from + (hour*100);
                    check = true;

                    x = i;
                }
            }

            int beforeHour = 0;
            double roomCost = 0.0;
            double paid = 0.0;

            beforeHour = bookList.get(x).getHour();
            roomCost = bookList.get(x).getRoomCost();
            paid = bookList.get(x).getPrice();


            if (check == true)
            {
                if(hour >= beforeHour)
                {
                    double updateHour = hour - beforeHour;
                    double topup = roomCost * updateHour;
                    updateNewCost = paid + topup;
                }
                else
                {
                    double updateHour = hour - beforeHour;
                    double topup = roomCost * updateHour;
                    updateNewCost = paid + topup;
                }

                printModify(beforeHour, hour, roomCost, paid, updateNewCost, from, till);

                System.out.print("Confirm Modification, Y/N: ");
                char yn = input.next().charAt(0);
                input.nextLine();

                //Set new from, till & new price calculated from printModify(updatePrice)
                if((yn == 'y' || yn == 'Y'))
                {
                            bookList.get(x).setFrom(from);
                            bookList.get(x).setTill(till);
                            bookList.get(x).setPrice(updateNewCost);
                            System.out.println("\nYou have succesfuuly modified your Booking ID: " + bookID);
                            entry = 9;
                        
                }
                else
                {
                    System.out.println("\nModification of your booking ID: " + bookID + " is Unsuccessful");
                    entry = 9;
                }
            }
            //Enters invalid booking ID
            else
            {
                System.out.println("\nBooking ID does not exist.");
                entry = 9;
            }
        } while (entry !=9);

    }

    private static void cancelBooking(String student)
    {
        int num = 0;
        int x = 0;
        Boolean check = false;


        do
        {
            System.out.print("\nEnter Booking ID number: ");
            num = input.nextInt();
            input.nextLine();

            for(int i = 0 ; i < bookList.size(); i++)
            {
                if(num == bookList.get(i).getbookID())
                {
                    check = true;
                    x = i;
                }
            }
            if(check == true)
            {
                printCancel(bookList.get(x).getPrice(),bookList.get(x).getbookID());

                System.out.print("\nConfirm Cancellation, Y/N: ");
                        char yn = input.next().charAt(0);
                        input.nextLine();

                        int removeBookNo = 0;
                        int addRoomNo = 0;
                        if((yn == 'y' || yn == 'Y'))
                        {
                            for(int j = 0 ; j < roomList.size(); j++)
                            {
                                for(int k = 0 ; k < bookList.size() ; k++)
                                {
                                    if(bookList.get(k).getName().equals(roomList.get(j).getName()))
                                    {
                                        addRoomNo = j;
                                        removeBookNo = k;  
                                    }
                                }
                            }

                            System.out.println("\nCancellation is Successful.");
                            roomList.get(addRoomNo).setAvail(true);
                            bookList.remove(removeBookNo);
                            entry = 9;
                        }
                        else
                        {
                            System.out.println("Cancellation is Unsuccessful");
                            entry = 9;
                        }
            }
            else
            {
                System.out.println("Booking ID does not exist");
                entry = 9;
            }
        } while (entry != 9);
                
    }


    //List of rooms for teachers to view (shown as a table)
    private static void printList()
    {
        String avail;
        System.out.println(line);
        System.out.printf("%-10s %-10s %-10s %-10s %-10s \t %-5s \t %-5s \n",
        "Number","Room","Capacity","Available", "Price", "From", "Till" );
        for(int i = 0 ; i < roomList.size() ; i++)
        {
            if(roomList.get(i).getAvail() == true)
                avail = "Yes";

            else
                avail = "No";

            System.out.printf("%-10s %-10s %-10d %-10s %-10s \t %04d \t %04d \n",
                            String.valueOf(i+1 + "."), roomList.get(i).getName(), roomList.get(i).getCap(), avail, 
                            String.valueOf(roomList.get(i).getPrice())+"/h", roomList.get(i).getFrom(), roomList.get(i).getTill());    
        }

    }

    //List of rooms for student to view (shown as a table)
    private static void printRoom()
    {
        System.out.println(line);
        System.out.printf("%-10s %-10s %-10s %-10s \t %-5s \t %-5s \n",
        "Number","Room","Capacity", "Price", "From", "Till" );

        for(int i = 0; i< roomList.size(); i++)
        {
            if(roomList.get(i).getAvail() == true)
            System.out.printf("%-10s %-10s %-10d %-10s \t %04d \t %04d \n",
                            String.valueOf(i+1 + "."), roomList.get(i).getName(), roomList.get(i).getCap(), 
                            String.valueOf(roomList.get(i).getPrice())+"/h", roomList.get(i).getFrom(), roomList.get(i).getTill()); 
        }
    }

    //List of rooms that are Booked (shown as a table)
    private static void printBook(String student)
    {
        System.out.println(line);
        System.out.printf("%-10s %-15s %-10s %-10s %-10s %-10s \t %-5s \t %-5s \n",
        "Number","Booking ID", "Student" , "Room","Capacity", "Price", "From", "Till" );

        for(int i = 0; i < bookList.size() ; i++)
        {
            if(student.equals(bookList.get(i).getStuName())) //For student to see (Only that student name)
            {
                System.out.printf("%-10s %-15s %-10s %-10s %-10s %-10s \t %04d \t %04d\n",
                                String.valueOf(i+1+"."), String.valueOf(bookList.get(i).getbookID()),
                                bookList.get(i).getStuName(), bookList.get(i).getName(), String.valueOf(bookList.get(i).getCap()), 
                                String.valueOf(bookList.get(i).getPrice()),
                                bookList.get(i).getFrom(), bookList.get(i).getTill());

            }
            /* 
            else //For teacher to see (Show all students )
            {
                System.out.printf("%-10s %-10s",String.valueOf(i+1+"."), bookList.get(i).toString());
            }
            */
        }

    }

    //MAKE BOOKING (PAYMENT PAGE)
    public static void printReciept(int hour, String promoName, double beforePrice, double discount, int from, int till, Boolean gotPromo)
    {
        double minus = beforePrice * (discount/100);
        double afterPrice = beforePrice - minus;

        System.out.println(line);
        System.out.println("***** Payment Page  *******");
        System.out.println("Time Slot: " + from + " - " + till);
        System.out.println("Total Hrs : " + hour);
        
        if (gotPromo == false)
        {
            System.out.println("Promo Code: null");
            System.out.println("Total: $"+ beforePrice);
        }
        else
        {
            System.out.println("Promo Code Applied: "+ promoName);
            System.out.println("Before Discount: $" + beforePrice);
            System.out.println("Discount: -$" + minus);
            System.out.println("Total: $"+ afterPrice);
        }    
    }

    //MODIFY BOOKING (PAYMENT PAGE)
    public static void printModify(int beforeHour,int newHour, double roomCost, double paid, double updateNewCost, int from, int till)
    {
        int updateHour = 0;
        double topup = 0.0;
        
        if(newHour >= beforeHour)
        {
            updateHour = newHour - beforeHour;
            topup = roomCost * updateHour;
            updateNewCost = paid + topup;

            System.out.println(line);
            System.out.println("***** Payment Page  *******");
            System.out.println("Before: " + beforeHour);
            System.out.println("Modify Hrs : " + newHour);
            System.out.println("Time Slot: " + from + " - " + till);
            System.out.println("Total: $" + updateNewCost);
            System.out.println("Top Up Additional: $" + topup);
        }
        else
        {
            updateHour = beforeHour - newHour;
            topup = roomCost * updateHour;
            updateNewCost = paid - topup;

            System.out.println(line);
            System.out.println("***** Modify Booking Page  *******");
            System.out.println("Before: " + beforeHour);
            System.out.println("Modify Hrs : " + newHour);
            System.out.println("Time Slot: " + from + " - " + till);
            System.out.println("Total: $" + updateNewCost);
            System.out.println("The sum of $" + topup + " will be credited back to your account.");  
        }
    }

    //CANCEL BOOKING (PAYMENT PAGE)
    public static void printCancel(double paid, int bookingID)
    {  
        System.out.println(line);
        System.out.println("***** Refund Page  *******");
        System.out.println("Cancel Booking for BookingID: " + bookingID);
        System.out.println("$" + paid + " will be credited back to your account.");        
    }

    private static void staffMenu()
    {
        System.out.println(line);
        System.out.println("Login as Staff\n");
		System.out.println("Welcome to SIM Room Booking System\n");
		System.out.println("1: Create Room\n");
		System.out.println("2: Launch Room\n");
		System.out.println("3: Adjust Price\n");
        System.out.println("4: Modify Time\n");
        System.out.println("5: Modify Room Capacity\n");
        System.out.println("6: View/Add/Remove Promo\n");
        System.out.println("7: Create Room by import\n");
        //System.out.println("8: Show Rooms that are booked by Students\n");
		System.out.println("9: Log Out\n");
		System.out.print("Your option: ");
    }

    private static void staffInterface()
    {
        int userInput;
        userInput = 0;
        
        do
        {
            staffMenu();
            userInput = input.nextInt();

            if (userInput == 1)
            {
                createRoom();
                printList();
            }
            else if (userInput == 2)
            {
                if(roomList.isEmpty())
                    System.out.println("There are no Rooms in the system. Please create a room.");
                else
                {
                    printList();
                    launchRoom();
                }
            }
            else if (userInput == 3)
            {
                if(roomList.isEmpty())
                    System.out.println("There are no Rooms in the system. Please create a room.");
                else
                {
                    printList();
                    adjustPrice();
                }
            }
            else if (userInput == 4)
            {
                if(roomList.isEmpty())
                    System.out.println("There are no Rooms in the system. Please create a room.");
                else
                {
                    printList();
                    adjustTime();
                }
            }
            else if (userInput == 5)
            {
                if(roomList.isEmpty())
                    System.out.println("There are no Rooms in the system. Please create a room.");
                else
                {
                    printList();
                    adjustCapacity();
                }

            }
            else if (userInput == 6)
            {
                adjustPromo();
            }

            else if (userInput == 7)
            {
                importRoomPromo();
                printList();
            }
            else if (userInput == 9)
            {
                System.out.println("\nSuccessfuly Logout");
            }
            else
            {
                System.out.println("\nPlease enter a valid option.");  
            }

        } while (userInput != 9);
    }

    private static void studentMenu(String student)
    {
        System.out.println(line);
        System.out.println("Login as Student: " + student + "\n");
		System.out.println("Welcome to SIM Room Booking System\n");
		System.out.println("1: View available Room\n");
		System.out.println("2: Make Booking\n");
        System.out.println("3: View Current Booking\n");
		System.out.println("4: Modify Existing booking\n");
        System.out.println("5: Cancel Booking\n");
		System.out.println("9: Log Out\n");
		System.out.print("Your option: ");
    }

    private static void studentInterface()
    {   
        int userInput;
        userInput = 0;
        String student = randomStudent();
        if(promoList.isEmpty() == false)
        {
            System.out.println(line);
            System.out.println("\n*****Current Promos*****");
            for(int i = 0 ; i < promoList.size() ; i++)
            {
                System.out.println(promoList.get(i).toString());
            }
        }

        do
        {   
            studentMenu(student); 
            userInput = input.nextInt();

            if(userInput == 1)
            {
                if(roomList.isEmpty())
                    System.out.println("\nRooms are fully booked");
                else
                {
                    System.out.println("\nAvailable Rooms for booking");
                    printRoom();   
                }
            }
            else if(userInput == 2)
            {
                if(roomList.isEmpty())
                    System.out.println("\nUnable to make a booking");
                else
                makeBook(student);

            }
            else if(userInput == 3)
            {
                if(bookList.isEmpty())
                    System.out.println("\nThere are no bookings");
                else
                printBook(student);
            }
            else if(userInput == 4)
            {
                if(bookList.isEmpty())
                System.out.println("\nThere are no bookings");
                else   
                modifyBook(student); //bug
            }

            else if(userInput == 5)
            {
                if(bookList.isEmpty())
                System.out.println("\nThere are no bookings");
                else
                cancelBooking(student);
            }
            else if (userInput == 9)
            {
                System.out.println("\nSuccessfuly Logout");
            }
            else
            {
                System.out.println("\nPlease enter a valid option.");  
            }
        } while (userInput != 9);
    }
    public static void main (String args[])
    {
        int login, stuPassword, stafPassword;
        login = 0;
        stuPassword = 12345;
        stafPassword = 54321;

        importRoomPromo(); //FOR TESTING REMOVE AFTERWARDS!******************************************
       
        do{
            System.out.print("\nEnter your Student / Staff ID: ");
            String id = input.nextLine();
            System.out.print("\nEnter your password: ");
            int pass = input.nextInt();
            input.nextLine();    

            String getid = id.substring(0,4);

            if((getid.equals("STUD") || getid.equals("stud")) && (pass == stuPassword))
            {
                studentInterface();
            }
            else if ((getid.equals("STAF") || getid.equals("staf"))  && (pass == stafPassword))
            {
                staffInterface();
            }     
            else
            {
                System.out.println("\nInvalid ID or Password");     
            }

            System.out.print("\nEnter 1 to login again: ");
            login = input.nextInt();
            input.nextLine();

        } while(login != 9876); //Termiate the program
    }
}