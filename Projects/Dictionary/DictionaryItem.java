// Name : Annanya Jain
// Section : CS 284 - C
// Pledge : I pledge my honor that I have abided by the Stevens Honor System.

public class DictionaryItem {
    // Two data fields: word and count.
    String word;
    int count;
    public DictionaryItem(String word, int count){
        // Constructor for  initializing the data fields.
        this.word = word;
        this.count= count;
    }

    // Getter and setter methods for the data fields in DictionaryItem

    public void setWord(String word){
        this.word = word;
    }

    public void setCount(int count){this.count = count;
    }

    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }

}

