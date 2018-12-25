package mobi.rayson.foundation.netty;


import mobi.rayson.foundation.netty.tcp.TcpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageUtils {

    private final Logger logger = LoggerFactory.getLogger(MessageUtils.class);

    public TcpMessage getMessageHead(String message) {
        logger.info("message: {}", message);
        TcpMessage tcpMessage = new TcpMessage();
        logger.info("开始设置头部信息");
        tcpMessage.setStartFlag(message.substring(0, 4));
        tcpMessage.setIdentifier(message.substring(4, 6));
        tcpMessage.setFlag(message.substring(6, 8));
        tcpMessage.setHeadEquipmentNo(message.substring(8, 16));
        tcpMessage.setSeq(message.substring(16, 20));
        tcpMessage.setDataLength(message.substring(20, 28));
        logger.info("tcpMessage：{}", tcpMessage);
        int head = 28;
        int length = Integer.valueOf(tcpMessage.getDataLength(), 16);
        logger.info("length: {}", length);
        tcpMessage.setCrcSign(subString(message, head + length * 2, 8));
        logger.info("tcpMessage2: {}", tcpMessage);
        logger.info("头部结束");
        return tcpMessage;
    }

    public String getRespStr(TcpMessage tcpMessage, String returnData) {
        byte[] dataBytes = ConvertCodeUtils.HexToByte(returnData);
        String respCrc = ConvertCodeUtils.crc32(dataBytes);
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("02");

        stringBuffer.append(ConvertCodeUtils.formatHexString(Long.toHexString(dataBytes.length), 8));
        stringBuffer.append(returnData);
        stringBuffer.append(respCrc);
        return stringBuffer.toString();
    }

    private String subString(String message, int start, int len) {
        logger.info("校验和：{}", message.substring(start, start + len));
        return message.substring(start, start + len);
    }
}
