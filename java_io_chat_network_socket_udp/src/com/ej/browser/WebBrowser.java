package com.ej.browser;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebBrowser {

	// �ڹٿ��� �� ������ ���� ����!
	public static void main(String[] args) {
		// URI: ������ �ּҸ� �ϳ��� ��ü�� ���� ��
	//	Desktop.getDesktop().browse(new URI("https://www.naver.com"));
		//�ܺ� ���� ������ try chtch �ʿ�
		
			try {
				Desktop.getDesktop().browse(new URI("https://www.naver.com"));
			} catch (IOException | URISyntaxException e) {
				System.err.println(e.getMessage());
			}
			/*
			 * }catch (IOException | URISyntaxException e) ��
			 * �Ʒ��� ����
			 * }catch (IOException e{
			 * 
			 * }catch(URISyntaxException e{
			 * }
			 * */
			
			}	
			

}	//end
