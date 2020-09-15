package com.company;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class Main {
    enum Month {
        Jan, Fab, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
    }
    enum AstroSign {
        Ram, Bull, Twins, Crab, Lion, Maiden, Scales, Scorpion, Archer, Goat, WaterBearer, Fish
    }
    enum AstroSignSymbols {
        aries, taurus, gemini, cancer, leo, virgo, libra, scorpio, sagittarius, capricorn, aquarius, pisces
    }
    public static void main(String[] args)  {
        Month month = inputMonth();
        int day = inputDay(month);
        AstroSign sign = getSign(month, day);
        System.out.println("your sign is " + sign + " aka " + AstroSignSymbols.values()[sign.ordinal()]);
        System.out.println("Press 'Enter' to show prediction...");
        new Scanner(System.in).next();
        printPrediction(sign);
    }

    public static void printPrediction(AstroSign sign) {
        String url = "https://www.astrology.com/horoscope/daily/" + AstroSignSymbols.values()[sign.ordinal()] + ".html";
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
    public static AstroSign getSign(Month month, int day) {
        if ((month == Month.Mar && day >= 21) || (month == Month.Apr && day <= 19)) return AstroSign.Ram;
        if ((month == Month.Apr && day >= 20) || (month == Month.May && day <= 20)) return AstroSign.Bull;
        if ((month == Month.May && day >= 21) || (month == Month.Jun && day <= 20)) return AstroSign.Twins;
        if ((month == Month.Jun && day >= 21) || (month == Month.Jul && day <= 22)) return AstroSign.Crab;
        if ((month == Month.Jul && day >= 23) || (month == Month.Aug && day <= 22)) return AstroSign.Lion;
        if ((month == Month.Aug && day >= 23) || (month == Month.Sep && day <= 22)) return AstroSign.Maiden;
        if ((month == Month.Sep && day >= 23) || (month == Month.Oct && day <= 22)) return AstroSign.Scales;
        if ((month == Month.Oct && day >= 23) || (month == Month.Nov && day <= 21)) return AstroSign.Scorpion;
        if ((month == Month.Nov && day >= 22) || (month == Month.Dec && day <= 21)) return AstroSign.Archer;
        if ((month == Month.Dec && day >= 22) || (month == Month.Jan && day <= 19)) return AstroSign.Goat;
        if ((month == Month.Jan && day >= 20) || (month == Month.Fab && day <= 18)) return AstroSign.WaterBearer;
        if ((month == Month.Fab && day >= 19) || (month == Month.Mar && day <= 20)) return AstroSign.Fish;
        throw new Error("wrong month/day");
    }
    public static Month inputMonth() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter you birth month(1-12):");
            int month = scan.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Wrong value");
                continue;
            }
            return Month.values()[month - 1];
        }
    }
    public static int getDayAmountInMonth(Month month) {
        int[] days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return days[month.ordinal()];
    }
    public static int inputDay(Month month) {
        Scanner scan = new Scanner(System.in);
        int daysInMonth = getDayAmountInMonth(month);
        while (true) {
            System.out.println("Enter your birth day(1-" + daysInMonth + "):");
            int day = scan.nextInt();
            if (day < 1 || day > daysInMonth) {
                System.out.println("wrong value");
                continue;
            }
            return day;
        }
    }
}
