package com.gwint.card.util;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public Integer getIntegerInListFromUser(List<Integer> possibleNumbers) {
        Integer integerFromUser;
        while (true) {
            try {
                integerFromUser = this.getIntegerFromUser();
            } catch (Exception e) {
                System.out.println("Invalid user input, try again");
                continue;
            }
            if (possibleNumbers.contains(integerFromUser)) {
                return integerFromUser;
            }
        }
    }

    public Integer getIntegerFromUser() {
        while (true) {
            String line = scanner.nextLine();
            boolean isValid = line.matches("[0-9]+");
            if (isValid) {
                return Integer.parseInt(line);
            }
        }
    }

    public String getNotEmptyStringFromUser() {
        String line;
        do {
            line = scanner.nextLine().trim();
        } while (line.isEmpty());
        return line;
    }

    public Boolean getBooleanFromUser() {
        String line;
        do {
            line = getNotEmptyStringFromUser();
        } while (!line.equals("true") && !line.equals("false"));
        return Boolean.parseBoolean(line);
    }

}
