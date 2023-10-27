import java.util.Random;

public class TratamentoPalavra {

    String palavra;

    public TratamentoPalavra(String palavra){
        this.palavra = palavra;
    }

    public void Embaralhar()
    {
        char[] arrayDeChar = palavra.toCharArray();
        embaralharArray(arrayDeChar);
        display(arrayDeChar);

    }
    public char[] getPalavraEbaralhada()
    {
        char[] arrayDeChar = palavra.toCharArray();
        embaralharArray(arrayDeChar);
        return arrayDeChar;
    }
    public int getArraydeCharLength()
    {
        char[] arrayDeChar = palavra.toCharArray();
        embaralharArray(arrayDeChar);
        return arrayDeChar.length;
    }
    public static void embaralharArray(char[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void display(char[] array){

        for(char c: array)
        {
            System.out.print(c + " ");
        }
    }
}