package org.rayson.foundation.netty.tcp;

import lombok.Data;

import java.io.Serializable;

@Data
public class TcpMessage<T> implements Serializable{


  private String startFlag;
  private String identifier;
  private String flag;
  private String headEquipmentNo;
  private String seq;
  private String dataLength;
  private T data;
  private String crcSign;

  public String toHeadString() {
    return "TcpMessage{" +
        "startFlag='" + startFlag + '\'' +
        ", identifier='" + identifier + '\'' +
        ", flag='" + flag + '\'' +
        ", headEquipmentNo='" + headEquipmentNo + '\'' +
        ", seq='" + seq + '\'' +
        ", dataLength='" + dataLength + '\'' +
        ", crcSign='" + crcSign + '\'' +
        '}';
  }
}
