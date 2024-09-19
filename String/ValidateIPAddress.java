package String;

public class ValidateIPAddress {
  public static void main(String[] args) {

    System.out.println(
        new ValidateIPAddress().validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
  }

  public String validIPAddress(String IP) {
    if (IP.contains(".")) {
      if (IP.endsWith(".") || IP.startsWith(".")) return "Neither";
      String[] ipv4 = IP.split("\\.");
      if (ipv4.length != 4) return "Neither";
      else {
        for (String part : ipv4) {
          if (part.isEmpty()) return "Neither";
          if (part.length() > 1 && part.startsWith("0")) return "Neither";
          else {
            if (part.length() > 3) return "Neither";
            for (char c : part.toCharArray()) {
              if (c < '0' || c > '9') return "Neither";
            }
            int value = Integer.parseInt(part);
            if (value < 0 || value > 255) return "Neither";
          }
        }
      }
      return "IPv4";
    } else if (IP.contains(":")) {
      if (IP.endsWith(":") || IP.startsWith(":")) return "Neither";
      String[] ipv6 = IP.split(":");
      if (ipv6.length != 8) return "Neither";
      else {
        for (String part : ipv6) {
          if (part.isEmpty()) return "Neither";
          if (part.length() > 4) return "Neither";
          else {
            for (char c : part.toCharArray()) {
              if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {

              } else {
                return "Neither";
              }
            }
          }
        }
      }
      return "IPv6";
    } else return "Neither";
  }
}
