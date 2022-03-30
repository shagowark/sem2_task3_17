import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        if (args.length == 0) {
            new Frame();
        } else {
            runInConsole(args);
        }
    }

    private static void runInConsole (String[] args) throws Exception {
        CmdLineArgsParser argsParser = new CmdLineArgsParser(args);

        String inputFilePath = argsParser.getArgumentValue("-i", "--input-file");
        String outputFilePath = argsParser.getArgumentValue("-o", "--output-file");

        SimpleLinkedListQueue2<String> queue = getQueue(inputFilePath);
        PriorityQueue<String> javaQueue = getQueueJava(inputFilePath);

        printQueues(javaQueue, queue, outputFilePath);
    }

    public static SimpleLinkedListQueue2<String> getQueue(String fileName) throws Exception{
        StringComparator comparator = new StringComparator();
        SimpleLinkedListQueue2<String> queue = new SimpleLinkedListQueue2<>(comparator);
        String[] words;
        String line;
        Scanner scanner = new Scanner(new File(fileName), StandardCharsets.UTF_8);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line == null) {
                break;
            } else {
                words = line.split("\\s");
                for (String elem : words){
                    queue.add(elem);
                }
            }
        }

        return queue;
    }

    public static PriorityQueue<String> getQueueJava(String fileName) throws Exception{
        StringComparator comparator = new StringComparator();
        PriorityQueue<String> queue = new PriorityQueue<>(comparator);
        String[] words;
        String line;
        Scanner scanner = new Scanner(new File(fileName), StandardCharsets.UTF_8);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line == null) {
                break;
            } else {
                words = line.split("\\s");
                queue.addAll(Arrays.asList(words));
            }
        }

        return queue;
    }


    public static void printQueues(PriorityQueue<String> queue1, SimpleLinkedListQueue2<String> queue2, String fileName) throws Exception{
        BufferedWriter writer =new BufferedWriter(new FileWriter(fileName));

        int j = queue1.size();
        for (int i = 0; i < j; i++){
            writer.write(queue1.remove()+"\s");
            writer.flush();
        }

        writer.write("\n");
        writer.flush();

        j = queue2.count();
        for (int i = 0; i < j; i ++){
            writer.write(queue2.remove()+"\s");
            writer.flush();
        }
    }
}
