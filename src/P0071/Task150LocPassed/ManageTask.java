/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0071.Task150LocPassed;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ManageTask {

    private final Scanner in = new Scanner(System.in);
    private final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputDate() {
        SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateOutput = new SimpleDateFormat("dd-MMM-yyyy");
        dateInput.setLenient(false);
        Date now = new Date();
        now.getTime();
        while (true) {
            try {
                //System.out.print("Enter Date:");
                Date date = dateInput.parse(in.nextLine());
                if (date.after(now)) {
                    System.out.println("Please input < curent date!");
                    continue;
                }
                return dateOutput.format(date);
            } catch (Exception e) {
                System.err.println("Re-Input");

            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputTaskTypeId() {
        while (true) {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }

    public String checkInputPlan() {
        while (true) {
            String result = checkInputString();
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
               
                return result;
            } else {
                System.err.println("Re-input.");
            }
        }
    }

    //get id to add in the end
    public int getIdtoAdd(ArrayList<Task> lt){
        int id=lt.size()-1;
        if(lt.isEmpty()){
            id=1;
        }else{
                id=lt.get(id).getId()+1;

        }
        return id;
    }


    public void addTask(ArrayList<Task> lt) {
        int id = getIdtoAdd(lt);
        System.out.print("Enter Requirement Name: ");
        String requirementName = checkInputString();
        System.out.print("Enter Task Type: ");
        String taskTypeId = checkInputTaskTypeId();
        System.out.print("Enter Date: ");
        String date = checkInputDate();
        System.out.print("Enter From: ");
        String planFrom = checkInputPlan();
        while (Double.parseDouble(planFrom)>=17.5) {            
            System.out.println("Enter plan from (<17.5): ");
            planFrom = checkInputPlan();
        }
        System.out.print("Enter To: ");
        String planTo = checkInputPlan();
        while (Double.parseDouble(planTo)<= Double.parseDouble(planFrom)) {            
            System.out.println("Plan From < Plan To");
            System.out.println("Enter again: ");
            planTo = checkInputPlan();
        }
        System.out.print("Enter Assignee: ");
        String assign = checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = checkInputString();
        lt.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
        System.err.println("Add Task Success.");
    }

    public void deleteTask(ArrayList<Task> lt, int id) {
        if (lt.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int findId = findTaskExist(lt);
        if (findId != -1) {
            lt.remove(findId);
//            for (int i = findId; i < lt.size(); i++) {
//                lt.get(i).setId(lt.get(i).getId() - 1);
//            }
            System.err.println("Delete success.");
        }
    }

    public int findTaskExist(ArrayList<Task> lt) {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }

    public void print(ArrayList<Task> lt) {
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getassign(),
                    lt.get(i).getreviewer()
            );

        }
    }

    public void display() {
        ArrayList<Task> lt = new ArrayList<>();
        lt.add(new Task(1, "code", "dev", "15-Jan-2020", "8.5", "17.5", "dad", "dfg"));
        lt.add(new Task(2, "code", "dev", "12-Feb-2020", "8.5", "17.5", "adsa", "sfs"));
        lt.add(new Task(3, "code", "dev", "30-Mar-2020", "8.5", "17.5", "dsad", "fsds"));
        int choice;
        int id =  0;
        while (true) {
            System.out.println("------MANAGEMENT TASK------");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addTask(lt);
                    break;
                case 2:
                    deleteTask(lt, id);
                    break;
                case 3:
                    print(lt);
                    break;
                case 4:
                    return;

            }
        }
    }
}
