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
	
	//����
	public static final String MC_PSW_ERR = "1";
	public static final String MC_SUCCESS = "10";
	public static final String MCLIST_LEFT = "shoplist\">";
	public static final String MCLIST_RIGHT = "</table>";
	public static final String MC_LEFT = "sel(this);";
	public static final String MC_RIGHT = "</tr>";
	public static final String MC_NAME_LF = "copyWord(\'";
	public static final String MC_NAME_RT = "\');";
	public static final String MC_ID_LF = "Display(";
	public static final String MC_ID_RT = ");\">";
	public static final String MC_LEVEL_LF = "left;\" >";
	public static final String MC_LEVEL_RT = "</td>";
	public static final String MC_GENRE_LF = "left;\">";
	public static final String MC_GENRE_RT = "</td>";
	
	//������Ϣ
	public static final String PUB_NAME_LF = "����ǳƣ�";
	public static final String PUB_NAME_RT = "</li>";
	public static final String PUB_JB_LF = "��ң�";
	public static final String PUB_JB_RT = "</li>";
	public static final String PUB_SJ_LF = "ˮ����";
	public static final String PUB_SJ_RT = "</li>";
	public static final String PUB_YB_LF = "Ԫ����";
	public static final String PUB_YB_RT = "</li>";
	
	//��ͨ��ͼ
	public static final String MAP_PT_XSJD = "1";
	public static final String MAP_PT_YJSL = "2";
	public static final String MAP_PT_CXHY = "3";
	public static final String MAP_PT_JSSM = "4";
	public static final String MAP_PT_HJL  = "5";
	public static final String MAP_PT_CRST = "6";
	public static final String MAP_PT_YMHS = "7";
	public static final String MAP_PT_SWSM = "8";
	public static final String MAP_PT_HSSL = "9";
	public static final String MAP_PT_BT   = "10";
	public static final String MAP_PT_HDSJ = "16";
	public static final String MAP_PT_SDXW = "15";
	
	//�´�½��ͼ
	public static final String MAP_XDL_SZ   = "100";
	public static final String MAP_XDL_PY   = "103";
	public static final String MAP_XDL_LYL  = "106";
	public static final String MAP_XDL_WZSY = "109";
	public static final String MAP_XDL_GW   = "112";
	public static final String MAP_XDL_TKZC = "115";
	public static final String MAP_XDL_TZL  = "118";
	public static final String MAP_XDL_WZL  = "121";
	public static final String MAP_XDL_SSYD = "20";
	
	//��ʥ��ͼ
	public static final String MAP_SS_MGZD = "131";//���֮��
	public static final String MAP_SS_BZL  = "134";//������
	public static final String MAP_SS_MWSL = "137";//����ɭ��
	public static final String MAP_SS_JSHY = "140";//��ʯ��Ұ
	public static final String MAP_SS_LLZQ = "145";//����֮Ȫ
	public static final String MAP_SS_SZZT = "148";//����֮��
	
	//����
	public static final String MAP_FB_YSW = "11";
	public static final String MAP_FB_HLW = "12";
	public static final String MAP_FB_SFK = "13";//ʷ�ҿ�˹��Ѩ
	public static final String MAP_FB_LLC = "14";//�����
	
	public static final String MAP_FB_EFS = "50";
	public static final String MAP_FB_ART = "124";
	public static final String MAP_FB_FLK = "127";//������
	
	public static final String MAP_FB_RYDG = "143";//���ҵع�
	public static final String MAP_FB_MHZJ = "144";//��ħ֮��
	
}
