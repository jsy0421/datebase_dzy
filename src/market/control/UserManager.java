package market.control;

import market.model.BeanUser;
import market.util.BaseException;
import market.itf.IUserManager;

public class UserManager implements IUserManager {

	/**
	 * ע�᣺
	 * Ҫ���û��������ظ�������Ϊ��
	 * ����������������һ�£����벻��Ϊ��
	 * ���ע��ʧ�ܣ����׳��쳣
	 * @param userid
	 * @param pwd  ����
	 * @param pwd2 �ظ����������
	 * @return
	 * @throws BaseException
	 */
	public BeanUser reg(String userid, String pwd,String pwd2,String type) throws BaseException {
		return null;
	}
	/**
	 * ��½
	 * 1������û������ڻ�����������׳�һ���쳣
	 * 2�������֤�ɹ����򷵻ص�ǰ�û���Ϣ
	 * @param userid
	 * @param pwd
	 * @param type   ����Ա�����û�
	 * @return
	 * @throws BaseException
	 */
	public BeanUser login(String userid,String pwd, String type)throws BaseException {
		return null;
	}
	/**
	 * �޸�����
	 * ���û�гɹ��޸ģ����׳��쳣
	 * @param user    ��ǰ�û�
	 * @param oldPwd  ԭ����
	 * @param newPwd  ������
	 * @param newPwd2 �ظ������������
	 */
	public void changePwd(BeanUser user, String oldPwd,String newPwd, String newPwd2)throws BaseException {
	}
}
