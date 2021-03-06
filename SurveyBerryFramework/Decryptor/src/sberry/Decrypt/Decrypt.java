package sberry.Decrypt;
import org.mindrot.jbcrypt.BCrypt;




/**This class is concerned with decrypting a hashcode to plain text
 * @author Fouad Abou Harfouche
 *
 */
public class Decrypt {
  	


	/**This method uses BCrypt to compare a password stored in hashcode to a password in plain text
	 * @param password_plaintext password in plain text
	 * @param stored_hash password in hashcode
	 * @return boolean password_verified
	 */
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}

	/**This method changes the hash to a hash that is compatible with BCrypt
	 * @param pass password in plain text
	 * @param hash password in hashcode
	 * @return boolean compare_test
	 */
	public static boolean decrypter(String pass, String hash) {
		
		hash="$2a"+hash.substring(3);
		boolean compare_test = checkPassword(pass, hash);
		return compare_test;
		
		

	}
	

}