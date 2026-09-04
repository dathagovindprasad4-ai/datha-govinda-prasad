class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            matrix.add(new ArrayList<>());
        }
        if(numRows==1)
        return s;
        int c = 0;
        int z = 0;
        boolean forward = true,backward = false;
        while(c<s.length()){
            char ch = s.charAt(c);
            matrix.get(z).add(ch);
            if(z==0 ){
                z++;
                forward = true;
                backward = false;
            }
            else if(z==(numRows-1))
            {
                z--;
                forward = false;
                backward = true;
            }
            else if(forward == true){
                z++;
            }
            else if(backward == true){
                z--;
            }
            c++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<matrix.size();i++){
            for(int j = 0;j<matrix.get(i).size();j++){
             sb.append( matrix.get(i).get(j));
            }
        }
        return sb.toString();
    }
}