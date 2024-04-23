public class Sum{

    //Zeichen an Stelle start von text ist eine Ziffer. Finde nun die erste Nicht-Ziffer. 
    public static int findEndIndex(String text, int start){
        for (int end ; end < text.length(); ++end){ 
            try{
                //Solange eine Ziffer entdeckt, setze Ende weiter.
                String chrEnde = text.substring(end, end+1);
                Integer.parseInt(chrEnde);
            } catch (NumberFormatException e){
                return end; //Erste Nicht-Ziffer gefunden
            }
        }
        return text.length();
    }

    public static int parseString(String text){
        int sum = 0;
        
        for (int start = 0; start < text.length(); ++start){
            try{
                //Prüfe, ob char eine Zahl ist. Gibt Start der Zahl
                String str = text.substring(start, start+1);
                Integer.parseInt(str);
                
                int end = findEndIndex(text, start);
                
                //Lese Zahl und addiere sie zum Ergebnis
                String zahlStr = text.substring(start, end);
                sum += Integer.parseInt(zahlStr);
                
                //Verschiebe Start
                start = end - 1;
            } catch (NumberFormatException e){
                //Zeichen war keine Ziffer. Fahre mit nächsten Zeichen fort.
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int summe = 0;
        for (int i = 0; i < args.length; ++i){
            try{
                //Versuche Zahl einzulesen
                int zahl = Integer.parseInt(args[i]);
                summe += zahl;
            } catch (NumberFormatException e){
                //Eingelesener String war keine Zahl!
                System.out.println(args[i] + " ist keine Zahl!");
                summe += parseString(args[i]);
            }
        }
        
        System.out.println("Die Summe ist " + summe);
    }
}