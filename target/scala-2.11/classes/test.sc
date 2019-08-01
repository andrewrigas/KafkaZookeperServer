import java.nio.file.Files

class fu(){
  def stop = 2
}

object d extends fu{

}
Files.createTempDirectory("kafka-logs").toString
d.stop