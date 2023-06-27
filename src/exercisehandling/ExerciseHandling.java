/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisehandling;

import java.util.Scanner;

/**
 *
 * @author mkhanda
 */
public class ExerciseHandling {
    static void checkOne(int hs) throws Numbeoutofrangeexception{
        if(hs < 100 || hs > 500){
            throw new Numbeoutofrangeexception("Hourly salary should be between the 100 - 500 range!");
        }
    }
    static void checkExchangeRate(int er) throws ExchangerateException {
        if (er == 90 || er == 150) {
            
        }
        else{
            throw new ExchangerateException("Sorry! Invalid Exchange rate value");
        }
    }
    
    static void getSalary(int[][] array) throws NumberFormatException, invalidGrade{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter job grade:"); 
        String response = s.next();
        boolean check = true;
        
        if(response.matches("-?(0|[1-9]\\d*)")){
            for(int i =0; i < 5; i++){
                if(array[i][0] == Integer.parseInt(response)){
                    System.out.println("The hourly salary for job grade "+response+ " is" + array[i][1] + "."); 
                }
            }
            if(check == false){
                throw new invalidGrade("Sorry! Job Grade value not found in Array!");
            }
        }
        else{
            throw new NumberFormatException("Error enter numeric value");
        }        
    }
        


    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] twoDArray = new int[5][2];
        boolean repeat = true;
        int counter = 0;
        boolean jobGradeNumeric = true;
        boolean hourlySalaryNumeric = true;
        boolean correctER = true;
        String hs = "";
        String jg = "";
        
        try{
        
            while(repeat){
                while(jobGradeNumeric){
                   System.out.println("Enter job grade:"); 
                   jg = s.next();

                    try{
                        Integer.parseInt(jg);
                        jobGradeNumeric = false;
                     }catch(NumberFormatException e){
                        System.out.println("Sorry! Non-numeric entry! Enter job grade of employee"); 
                    }
                }

                while (hourlySalaryNumeric) {
                    System.out.println("Enter hourly salary:");
                    hs = s.next();

                    try {
                        Integer.parseInt(hs);
                        try{
                            checkOne(Integer.parseInt(hs));
                            hourlySalaryNumeric = false;
                        }                                
                        catch(Numbeoutofrangeexception ex){
                            System.out.println(ex);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Sorry! Non-numeric entry! Enter hourly salary of employee");
                    }
                }

                int[] x = {Integer.parseInt(jg), Integer.parseInt(hs)};
                twoDArray[counter] = x;


                while(correctER){
                    System.out.println("Enter Exchange rate:");
                    int er = s.nextInt();

                    try{
                        checkExchangeRate(er);
                        correctER = false;
                        System.out.println("The hourly salary has been converted to "+ (Double.valueOf(hs)*Double.valueOf(er)));
                    }catch(ExchangerateException ey){
                        System.out.println(ey);
                    }

                }
                counter++;

                System.out.println("Would you like to enter another record:");
                String answer = s.next();



                if(answer.equals("no")){
                    repeat = false;
                    break;

                }
                else{
                    jobGradeNumeric = true;
                    hourlySalaryNumeric = true;
                    correctER = true;
                }
            }

        }
        catch(ArrayIndexOutOfBoundsException e){
                System.out.println("The index you entered is invalid");
                
                try{
                    getSalary(twoDArray);
                }
                catch(NumberFormatException ey){
                    System.out.println(ey);
                }
                catch(invalidGrade ej){
                    System.out.println(ej);
                }
            }
        }
    }

        
