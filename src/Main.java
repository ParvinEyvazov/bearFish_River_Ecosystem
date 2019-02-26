
import java.util.Random;

//@ author is Parvin Eyvazov

public class Main {
    public static void main(String[] args) {

        Object[][] River = new Object[10][10];


        fillArray(River);

        showArray(River);



        for (int i =0 ;i<5 ; i++){

            System.out.println("\n\n\n\n");

            movingArray(River);
            showArray(River);



        }

    }

    public static void movingArray(Object[][] a) {   //moving elements in Array
       Random random = new Random();
       int row ,col;
       int x,y;

       int nRow = a.length;
       int nCol = a[nRow-1].length;

       for(int i = 0 ; i<nRow ; i++){                //Starting to to scan Array and
           for (int j=0; j<nCol ; j++){
               x = random.nextInt(3);
               y = random.nextInt(3);
               if (x==2 )
                   x= -1;
               if (y==2  )
                   y = -1;

               if (i+y <0 || j+x <0 || i+y >nRow-1 || j+x >nCol-1)
                   continue;
               else{
                   if(a[i+y][j+x] == null) {
                       a[i+y][j+x] = a[i][j];
                       a[i][j] =null;

                   }
                   // 2 bear condition
                   else if (a[i+y][j+x] instanceof Bear && a[i][j] instanceof Bear){
                       do {
                           row = random.nextInt(nRow);
                           col = random.nextInt(nCol);
                       } while (a[row][col] != null);
                       a[row][col] = new Bear();

                   }

                   //2 Fish condition
                   else if (a[i+y][j+x] instanceof Fish && a[i][j] instanceof Fish){
                       do {
                           row = random.nextInt(nRow);
                           col = random.nextInt(nCol);
                       }while (a[row][col] != null);

                       a[row][col] = new Fish();
                   }
                   // Fish move Bear`s place -Bear eat it,Bear stay
                   else if (a[i+y][j+x] instanceof Bear && a[i][j] instanceof Fish){
                       a[i][j] =null;
                   }
                   // Bear moves Fish`s place -Bear eat it again
                   else if (a[i+y][j+x] instanceof Fish && a[i][j] instanceof Bear){
                       a[i+y][j+x] = a[i][j];
                       a[i][j] = null;
                   }
               }
           }
       }
    }

    public static void fillArray(Object[][] a) {
        for(int i = 0; i<a.length ; i++){
            for(int j = 0 ; j<a[i].length ; j++){
                int temp = (int)(Math.random()*100);

                if (temp <=25){   // if random number smaller than 25
                    a[i][j] = new Bear().name();
                }
                if(temp>25 && temp<50){   //if random number is in between 25 and 50
                    a[i][j] = new Fish().name();
                }
                else continue;    //if random number is bigger than 50


            }



        }

    }

    public static void showArray(Object[][] a){
        for(int i= 0; i<10; i++){
            for(int j = 0; j<10;j++){


                System.out.print(a[i][j]+ " | ");


            }
            System.out.println();


        }



    }


}
