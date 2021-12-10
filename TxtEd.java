import java.io.*;
import java.util.*;

public class TxtEd implements TxtEdInterface{

    private List<String> contentList;
    private Map<String, String> commandMap = new HashMap<>();
    private String filepath;

    @Override
    public void reset() {
        this.contentList = new ArrayList<>();
        this.commandMap = new HashMap<>();
        this.filepath = null;
    }

    @Override
    public void setFilepath(String filepath){
        if(Objects.isNull(filepath) || Objects.equals("",filepath)){
            System.err.println("file is empty");
            return;
            //throw new TxtEdException("file is empty");
        }

        this.filepath = filepath;

        // 使用ArrayList来存储每行读取到的字符串
        contentList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                contentList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setStringToExclude(String excludeString) {
        commandMap.put("-e",excludeString);
    }

    @Override
    public void setCaseInsensitive(boolean caseInsensitive) {
        if(caseInsensitive){
            commandMap.put("-i","true");
        }

    }

    @Override
    public void setSkipLines(boolean skipLines, int lineToSkip){
        if(skipLines){
            commandMap.put("-s",lineToSkip+"");
        }

    }

    @Override
    public void setReverseFile(boolean reverseFile) {
        commandMap.put("-r","");
    }

    @Override
    public void setSuffix(String suffix) {
        commandMap.put("-x",suffix);
    }

    @Override
    public void setAddLineNumber(boolean addLineNumber, int padding) {
        if(addLineNumber){
            commandMap.put("-n",padding+"");
        }
    }

    @Override
    public void setInplaceEdit(boolean inplaceEdit) {
        commandMap.put("-f","");
    }

    @Override
    public void txted() throws TxtEdException {

        if(commandMap.containsKey("-i") && !commandMap.containsKey("-e")){
            /*//TODO  抛错
            System.err.println("key -i is not find key -e");
            return;*/

            throw new TxtEdException("key -i is not find key -e");
        }

        if(commandMap.containsKey("-s")){
            Integer num = Integer.parseInt(commandMap.get("-s"));
            if(num != 0 && num != 1){
                /*//TODO  抛错
                System.err.println("key -s val is [0,1]");
                return;*/
                throw new TxtEdException("key -s val is [0,1]");
            }
        }

        List<String> results = new ArrayList<>();
        int i = 1;
        for (String val : contentList){


            if(commandMap.containsKey("-s")){
                Integer num = Integer.parseInt(commandMap.get("-s"));
                if(num == 0){
                    // 偶数行 删除
                    if(i % 2 == 0){
                        val = null;
                    }
                }else{
                    // 奇数行 删除
                    if(i % 2 != 0){
                        val = null;
                    }
                }

                i++;
            }


            if(Objects.nonNull(val)){
                if(commandMap.containsKey("-e")){
                    String keyE = commandMap.get("-e");
                    if(commandMap.containsKey("-i")){
                        if(val.toLowerCase().contains(keyE.toLowerCase())){
                            val = null;
                        }
                    }else{
                        if(val.contains(keyE)){
                            val = null;
                        }
                    }
                }

                if(Objects.nonNull(val)){
                    if(commandMap.containsKey("-x")){
                        String keyX = commandMap.get("-x");
                        val += keyX;
                    }

                    results.add(val);

                }

            }


        }

        if(commandMap.containsKey("-r")){
            Collections.reverse(results);
        }

        String prefix = "";
        boolean addPrefix = false;
        if(commandMap.containsKey("-n")){
            Integer keyN = Integer.parseInt(commandMap.get("-n"));
            if(keyN > 1){
                StringBuilder  sb = new StringBuilder();
                for (int j = 0; j < keyN - 1; j++) {
                    sb.append("0");
                }
                prefix = sb.toString();
                addPrefix = true;
            }

        }

        try {
            FileWriter fw = null;
            BufferedWriter bw = null;
            try{

                if(commandMap.containsKey("-f")) {
                    fw = new FileWriter(filepath, false);
                    bw = new BufferedWriter(fw);
                }
                int calNum = 1;
                for(String val : results){
                    if(addPrefix){
                        val = prefix+calNum+" " + val;
                        calNum++;
                    }

                    if(commandMap.containsKey("-f")){

                        // 写文件
                        bw.write(val + System.lineSeparator());


                    }else{
                        System.out.println(val);
                    }
                }
            }finally {
                if(bw != null){
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

