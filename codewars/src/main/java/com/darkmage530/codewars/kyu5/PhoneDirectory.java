package com.darkmage530.codewars.kyu5;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/56baeae7022c16dd7400086e
 */
public class PhoneDirectory {

    private static final String NAME_PATTERN = "(?<=<).*?(?=>)";
    private static final String NUMBER_PATTERN = "\\+\\d{1,2}-\\d{3}-\\d{3}-\\d{4}";
    private static final String PRESERVED_CHARACTERS = "[^a-zA-Z0-9. -]";
    private static final String MULTIPLE_SPACES = " +";

    public static void main(String[] args) {
        phone("", "");
    }

    public static String phone(String strng, String num) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        return phoneDirectory.findInfo(strng, num);
    }

    private String findInfo(String addressBook, String lookupPhoneNumber) {
        StringReader sr = new StringReader(addressBook);
        BufferedReader br = new BufferedReader(sr);

        Set<String> matchingLines = br.lines().filter(line -> line.contains("+" + lookupPhoneNumber)).collect(Collectors.toSet());

        if (matchingLines.isEmpty()) {
            return "Error => Not found: " + lookupPhoneNumber;
        } else if (matchingLines.size() > 1) {
            return "Error => Too many people: " + lookupPhoneNumber;
        }

        String addressBookLine = matchingLines.iterator().next();

        AddressEntry addressEntry = new AddressEntry();
        addressEntry.updatePhoneNumber(lookupPhoneNumber);
        addressEntry.updateName(retrieveName(addressBookLine));
        addressEntry.updateAddress(retrieveAddress(addressBookLine));

        return addressEntry.returnFormattedEntry();
    }

    String retrieveName(String addressLine) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(addressLine);
        matcher.find();

        //This may throw an exception, but the instructions says we'll have a < > for the name
        return matcher.group().trim();
    }

    String retrieveAddress(String addressLine) {
        String modifiedAddressLine = addressLine.replaceAll(NAME_PATTERN, "");
        modifiedAddressLine = modifiedAddressLine.replaceAll(NUMBER_PATTERN, "");
        modifiedAddressLine = modifiedAddressLine.replaceAll(PRESERVED_CHARACTERS, " ");
        modifiedAddressLine = modifiedAddressLine.replaceAll(MULTIPLE_SPACES, " ");

        return modifiedAddressLine.trim();
    }

    private class AddressEntry {
        private String phoneNumber = "";
        private String name = "";
        private String address = "";

        private void updatePhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        private void updateName(String name) {
            this.name = name;
        }

        private void updateAddress(String address) {
            this.address = address;
        }

        private String returnFormattedEntry() {
            return "Phone => " + phoneNumber + ", Name => " + name + ", Address => " + address;
        }
    }
}
