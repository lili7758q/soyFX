package soyUtils;
/** 
* @author Soy 
* @date 2017��11��16�� ����3:53:03 
* @version 1.0 
* @description ����
*/
public class Const {
	/*���÷�����*/
	public static final String CODE_SUCCESSED = "0";
	
	/*Http״̬��*/
	public static final int CODE_OK = 200;
	public static final int CODE_BAD_GATEWAY = 502;
	public static final int CODE_NOT_FOUND = 404;
	public static final int CODE_MOVE = 302; //�˺����벻��ȷ
	
	/*����*/
	public static final String UTF_8 = "utf-8";
	public static final String GB2321 = "gb2312";
	
	/*
	 * �Ķ��������û��ö��ֵ��ֱ�ӷ���һ���ַ���
	 */
	public static final String SELL_0  = "0";//�ɹ�
	public static final String SELL_4  = "4";//����������Ʒ�����Ѵ�����,��ȡ���ѹ��ڵ���Ʒ��
	public static final String SELL_5  = "5";//����Ʒ���ɽ���
	public static final String SELL_10 = "10";//���ı�����û���㹻����Ʒ����������
	public static final String SELL_11 = "11";//����Ʒ�Ѿ�������������ȡ�غ��ټ���������
	public static final String SELL_12 = "12";//������̫�죬���Ժ����ԣ�
	
	/*
	 * ���������û��ö��ֵ��ֱ�ӷ���һ���ַ���
	 */
	public static final String BUY_0  = "0";//�ɹ�
	public static final String BUY_3  = "3";//������Ʒ����̫�࣡
	public static final String BUY_4  = "4";//�����ռ䲻�㣡
	public static final String BUY_5  = "5";//������̫�죡
	public static final String BUY_7  = "7";//����Ʒ�����������Ŷ��
	public static final String BUY_8  = "8";//��̫���ˣ����������ˣ�
	public static final String BUY_10 = "10";//���Ľ�Ҳ�����
	
	/*
	 * ���������û��ö��ֵ��ֱ�ӷ���һ���ַ���
	 */
	public static final String JH_0  = "0";//����ʧ�ܣ�
	public static final String JH_1  = "1";//��ϲ�������������ɹ�!!
	public static final String JH_2  = "2";//ȱ�ٽ�������Ʒ��
	public static final String JH_3  = "3";//�����ĵȼ�̫�ͣ������ܽ�����
	public static final String JH_4  = "4";//������ʱ�����ܽ��������߼�
	public static final String JH_5  = "5";//��û���㹻��ҽ��н�����
	public static final String JH_6  = "6";//���Ѿ��ﵽ���Ľ��������ˣ�
	
	/*
	 * �ϳɽ����û��ö��ֵ��ֱ�ӷ���һ���ַ���
	 * ���β���type1
	 * ��װ���ϣ��Ӳ���type=do&type1=check
	 * ���ӻ����࣬�Ӳ���type1=check
	 */
	public static final String HC_0 = "";//�ϳ�ʧ�ܣ���
	public static final String HC_1 = "";//��û����Ӧ�ĳ���
	public static final String HC_2 = "";//��������������ܺϳ���!
	public static final String HC_3 = "";//���Ľ�Ҳ��㣬���ܺϳ�!
	public static final String HC_5 = "";//�ɹ�
	public static final String HC_6 = "";//ʧ��
	public static final String HC_10 = "";//���ݶ�ȡʧ��!
	public static final String HC_11 = "";//��ȴʱ��δ����
	public static final String HC_15 = "";//����ɳ�δ�ﵽ�ϳ�����Ŷ��
	public static final String HC_20 = "";//�Բ������ı�����û�д���Ʒ!
	public static final String HC_200 = "";//δ��ӻ��������
	public static final String HC_1000 = "";//������װ��
	
	/*��Ʒpids*/
	public static final String pids_94   = "94";//����֮��
	public static final String pids_95   = "95";//�߽�
	public static final String pids_107  = "107";//����
	public static final String pids_747  = "747";//����
	public static final String pids_748  = "748";//A��
	public static final String pids_749  = "749";//B��
	public static final String pids_1221 = "1221";//��¶
	public static final String pids_1222 = "1222";//������¶
	
	/*������*/
	public static final String BUY_RET_SUCCESS = "0";//�ɹ�
	public static final String BUY_RET_TOOMANY = "3";//������Ʒ����̫�࣡
	public static final String BUY_RET_NEEDSPACE = "4";//�����ռ䲻�㣡
	public static final String BUY_RET_TOOFAST = "5";//������̫�죡
	public static final String BUY_RET_NOTYOU = "7";//����Ʒ�����������Ŷ��
	public static final String BUY_RET_SALEOUT = "8";//��̫���ˣ����������ˣ�
	public static final String BUY_RET_NOMONEY = "10";//���Ľ�Ҳ�����
	/*�ָ�*/
	//bag
	public static final String BAG_LEFT = "<li><a >";
	public static final String BAG_RIGHT = "</a></li>";
	public static final String ID_LEFT = "id=\"t";
	public static final String ID_RIGHT = "\" onmouseover";
	public static final String NAME_LEFT = "copyWorda(\'";
	public static final String NAME_RIGHT = "');\" style";
	public static final String NUM_LEFT ="class=\"p4\">";
	public static final String NUM_RIGHT ="</p>";
	public static final String SORT_LEFT ="class=\"p3\">";
	public static final String SORT_RIGHT ="</p>";
	//sale
	public static final String SALELIST_LEFT = "shoplist\">";
	public static final String SALELIST_RIGHT = "</table>";
	public static final String SALE_LEFT = "sel(this);";
	public static final String SALE_RIGHT = "</td>";
	public static final String SALEID_LEFT = "bid=";
	public static final String SALEID_RIGHT = ";";
	public static final String SALENAME_LEFT = ">";
	public static final String SALENAME_RIGHT = "(";
	public static final String SALEPRICE_LEFT = "price=";
	public static final String SALEPRICE_RIGHT = ";\"";
	public static final String SALENUM_LEFT = "(";
	public static final String SALENUM_RIGHT = ")";
	
}
