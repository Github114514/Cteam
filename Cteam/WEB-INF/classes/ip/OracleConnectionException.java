package ip;

import java.sql.SQLException;

public class OracleConnectionException extends SQLException{
  public OracleConnectionException(String mess,Throwable e){
    super(mess,e);
  }
}