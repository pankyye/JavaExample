package StringProcessing;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcess implements StringProcessInterface{
    private String str;

    @Override
    public String getString() {
        return this.str;
    }

    @Override
    public void setString(String string) {
        String easterEgg = "easterEgg";
        if(Objects.equals(string,easterEgg)){
            throw new IllegalArgumentException();
        }
        this.str = string;
    }

    @Override
    public int countNumbers(){
        if (Objects.isNull(this.str)){
            throw new NullPointerException();

        }
        int num = 0;
        String[] ss = this.str.split(" |,|\\.");
        for(String s :ss){
            String trim = s.trim();
            char[] chars = trim.toCharArray();
            boolean isStr = true;
            for(char c : chars){
                if(Character.isDigit(c)){
                    if(isStr){
                        num++;
                    }
                    isStr = false;
                } else{
                    isStr = true;
                }
            }
        }
        return num;
    }


    @Override
    public String addNumber(int n, boolean inverse) {
        if(Objects.isNull(str)){
            throw new NullPointerException();
        }

        if(n < 0){
            throw new IllegalArgumentException("parameter should not be nagetive");
        }

        Map<String,String> map = new TreeMap<>();

        String[] ss = str.split(" |,");
        for(String s : ss){

            String val = s.trim();
            if(isNumber(val)){
                int num = Integer.parseInt(val);
                int currentValInt = Math.abs(Integer.parseInt(val))+ n;
                String currentVal = String.valueOf(currentValInt);
                if(num < 0){
                    currentVal = "-"+currentVal;
                }
                if(inverse){
                    currentVal = new StringBuilder(currentVal).reverse().toString();
                }

                map.put(val,currentVal);
            }


        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            str = str.replace(k, v);
        }


        return str;
    }

    private static boolean isNumber(String str){

        Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher((CharSequence) str);
        boolean result = matcher.matches();
        if (result) {
            return true;
        } else {
            return false;
        }


    }




    @Override
    public void convertDigitsToNamesInSubstring(int firstPosition, int finalPosition){
        if(Objects.isNull(this.str)){
            throw new NullPointerException();
        }

        if(firstPosition < 1 || firstPosition > finalPosition){
            throw new IllegalArgumentException();
        }

        if(finalPosition > this.str.length()){
            throw new MyIndexOutOfBoundsException();
        }

        String oldVal = this.str.substring(firstPosition -1, finalPosition);
        String newval = oldVal;
        char[] chars = oldVal.toCharArray();
        for(char c :chars){
            if(Character.isDigit(c)){
                int num = Integer.parseInt(String.valueOf(c));
                String val = "";
                switch (num){
                    case 0:
                        val = "ZERO";
                        break;
                    case 1:
                        val = "ONE";
                        break;
                    case 2:
                        val = "TWO";
                        break;
                    case 3:
                        val = "THREE";
                        break;
                    case 4:
                        val = "FOUR";
                        break;
                    case 5:
                        val = "FIVE";
                        break;
                    case 6:
                        val = "SIX";
                        break;
                    case 7:
                        val = "SEVEN";
                        break;
                    case 8:
                        val = "EIGHT";
                        break;
                    case 9:
                        val = "NINE";
                        break;
                    default:
                        break;
                }
                if(!val.isEmpty()){
                    newval = newval.replace(String.valueOf(c),val);
                }
            }
        }

        String ret = this.str.replaceFirst(oldVal,newval);
        this.str = ret;
        System.out.println(ret);
    }


}