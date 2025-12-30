import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class App {

    public static void main(String[] args) throws Exception {
        
        calculateDataHour();
    }

    public static void dateFunction() {

        // 1 - gerar data atual local V
        // 2 - gerar data e hora atual local V
        // 3 - gerar data e hora global V
        // 4 - converter texto para data local  V
        // 5 - converter texto para data e hora local V
        // 6 - converter texto para data e hora global V
        // 7 - converter texto data e hora local para data e hora global V
        // 8 - definir novo formato de data e usar V 
        // 9 - definir novo formato de data e hora e usar V
        // 10 - criar data e hora local V
        // 11 - importar as classes necessárias V 

        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant zeroDate = Instant.now();

        LocalDate anyDate = LocalDate.parse("2025-03-10");
        LocalDateTime anyDateTime = LocalDateTime.parse("2025-03-10T18:06:10");
        Instant zeroDateParsed = Instant.parse("2025-03-10T18:06:10-03:00");

        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime zeroDateFormat = LocalDateTime.parse("10/03/2025 18:06", newFormat); 

        System.out.printf("DATA LOCAL: %s \n", currentDate);
        System.out.printf("DATA E HORA LOCAL: %s \n", currentDateTime);
        System.out.printf("DATA E HORA DE LONDRES: %S \n", zeroDate);
        System.out.println("------");

        System.out.printf("QUALQUER DATA: %s \n", anyDate);
        System.out.printf("QUALQUER DATA E HORA:: %s \n", anyDateTime);
        System.out.printf("QUALQUER DATA EM LONDRES: %s \n", zeroDateParsed);
        System.out.printf("DATA FORMATADA LOCAL: %s \n", zeroDateFormat);
    }

    public static void dateToText() {

        // 12 - Converter uma data para texto formatado das duas formas V
        // 13 - criar um formato usando fuso-horário local V
        // 14 - criar formato data ISO local V
        // 15 - Criar formato ISO com fuso horário de Londres V

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt3 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_INSTANT;

        LocalDateTime d01 = LocalDateTime.parse("2023-06-20T13:50:30");
        Instant d02 = Instant.parse("2023-06-20T13:50:30-03:00"); // agora válido

        System.out.printf("Formato padrão texto = %s \n", fmt1.format(d01));
        System.out.printf("Formato com fuso horário local = %s \n", fmt2.format(d02));
        System.out.printf("Formato ISO = %s \n", fmt3.format(d01));
        System.out.printf("Formato ISO com fuso horário de Londres = %s \n", fmt4.format(d02));
    }

    public static void localGlobal() {

        // 2 - converter data hora de um fuso horário para outro
        // 3 - converter data hora para fuso horário local
        // 4 - obter dia, mês e ano de uma data
        // 5 - obter horas e minutos de uma data hora

        Instant d01 = Instant.parse("2025-03-20T01:30:30Z");

        LocalDateTime d02 = LocalDateTime.ofInstant(d01, ZoneId.systemDefault());
        int dayLocal = d02.getDayOfMonth();
        int monthLocal = d02.getMonthValue();
        int yearLocal = d02.getYear();
        int hourLocal = d02.getHour();
        int minutesLocal = d02.getMinute();
        int secondsLocal = d02.getSecond();

        LocalDateTime d03 = LocalDateTime.ofInstant(d01, ZoneId.of("Cuba"));

        System.out.printf("Londres = %s \n \n", d01);

        System.out.printf("Local = %s \n", d02);
        System.out.printf("DIA LOCAL = %s \n", dayLocal);
        System.out.printf("MÊS LOCAL = %s \n", monthLocal);
        System.out.printf("ANO LOCAL = %s \n", yearLocal);
        System.out.printf("HORA LOCAL = %s \n", hourLocal);
        System.out.printf("MINUTOS LOCAL = %s \n", minutesLocal);
        System.out.printf("SEGUNDOS LOCAL = %s \n \n", secondsLocal);

        System.out.printf("Cuba = %s \n", d03);

    }

    public static void getZoneIds() {

        // 1 - ver os zoneIds disponíveis

        Set<String> zoneIds = ZoneId.getAvailableZoneIds();

        for(String local : zoneIds) {

            System.out.printf("%s \n", local);
        }
    }

    public static void calculateDataHour() {

        // 1 - aumentar dias de uma data
        // 2 - diminuir meses de uma data
        // 3 - converter um LocalDate para LocalDateTime para assim poder obter duração em minutos, etc.
        // 4 - obter a duração em dias entre uma data e outra

        LocalDate d01 = LocalDate.parse("2025-05-17");
        LocalDateTime d02 = d01.atTime(0, 0);

        LocalDateTime plusDays = d02.plusDays(7);
        LocalDateTime minusMonths = d02.minusMonths(2);

        Long t01 = Duration.between(d02, plusDays).toDays();

        System.out.printf("DATA INICIAL: %s \n", d01);
        System.out.printf("DATA COM HORA: %s \n \n", d02);

        System.out.printf("DATA COM MAIS 7 DIAS = %s \n", plusDays);
        System.out.printf("DATA COM MENOS 2 MESES = %s \n \n", minusMonths);

        System.out.printf("DURAÇÃO DATA LOCAL E DATA FINAL = %s", t01);


        
    }
}
