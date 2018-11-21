package serializable.serialization;

import java.io.Serializable;

class User implements Serializable{
  transient int lifeLevel;
  static int staticField;
  transient Sord sord;
}
