package present.play;

/**
 * Created by Kos on 22.07.2014.
 */
public class Starter {
    MessageWriter messageWriter;
    public void doProgram(){
        String mes = messageWriter.getMessage();
        System.out.print(mes);
    }

    public Starter() {
        System.out.print("New Starter");
    }

    public void setMessageWriter(MessageWriter messageWriter) {
        this.messageWriter = messageWriter;
    }
}
