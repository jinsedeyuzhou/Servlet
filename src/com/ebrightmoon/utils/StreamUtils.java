package com.ebrightmoon.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class StreamUtils {

	final static int BUFFER_SIZE = 4096;

	/**
	 * ��InputStreamת����String
	 *
	 * @param in
	 *            InputStream
	 * @return String
	 * @throws Exception
	 */
	public static String InputStreamTOString(InputStream in) {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		String string = null;
		int count = 0;
		try {
			while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
				outStream.write(data, 0, count);
		} catch (IOException e) {
			e.printStackTrace();
		}

		data = null;
		try {
			string = new String(outStream.toByteArray(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}

	/**
	 * ��InputStreamת����ĳ���ַ������String
	 *
	 * @param in
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String InputStreamTOString(InputStream in, String encoding) {
		String string = null;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		try {
			while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
				outStream.write(data, 0, count);
		} catch (IOException e) {
			e.printStackTrace();
		}

		data = null;
		try {
			string = new String(outStream.toByteArray(), encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}

	/**
	 * ��Stringת����InputStream
	 *
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static InputStream StringTOInputStream(String in) throws Exception {

		ByteArrayInputStream is = new ByteArrayInputStream(in.getBytes("UTF-8"));
		return is;
	}

	/**
	 * ��Stringת����InputStream
	 *
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static byte[] StringTObyte(String in) {
		byte[] bytes = null;
		try {
			bytes = InputStreamTOByte(StringTOInputStream(in));
		} catch (IOException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}

	/**
	 * ��InputStreamת����byte����
	 *
	 * @param in
	 *            InputStream
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] InputStreamTOByte(InputStream in) throws IOException {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);

		data = null;
		return outStream.toByteArray();
	}

	/**
	 * ��byte����ת����InputStream
	 *
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static InputStream byteTOInputStream(byte[] in) throws Exception {

		ByteArrayInputStream is = new ByteArrayInputStream(in);
		return is;
	}

	/**
	 * ��byte����ת����String
	 *
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static String byteTOString(byte[] in) {

		InputStream is = null;
		try {
			is = byteTOInputStream(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return InputStreamTOString(is, "UTF-8");
	}

	/**
	 * ��byte����ת����String
	 *
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static String getString(String in) {

		String is = null;
		try {
			is = byteTOString(StringTObyte(in));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	// InputStream ת����byte[]
	public byte[] getBytes(InputStream is) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] b = new byte[BUFFER_SIZE];
		int len = 0;

		while ((len = is.read(b, 0, BUFFER_SIZE)) != -1) {
			baos.write(b, 0, len);
		}

		baos.flush();

		byte[] bytes = baos.toByteArray();

		System.out.println(new String(bytes));

		return bytes;
	}

	/**
	 * �����ļ�·�������ļ����������� ���ֽ�Ϊ��λ���� unicode ��
	 *
	 * @param path
	 * @return
	 */
	public static FileInputStream getFileInputStream(String filepath) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			System.out.print("������Ϣ:�ļ�������");
			e.printStackTrace();
		}
		return fileInputStream;
	}

	/**
	 * �����ļ����󴴽��ļ����������� ���ֽ�Ϊ��λ���� unicode ��
	 *
	 * @param path
	 * @return
	 */
	public static FileInputStream getFileInputStream(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.print("������Ϣ:�ļ�������");
			e.printStackTrace();
		}
		return fileInputStream;
	}

	/**
	 * �����ļ����󴴽��ļ���������� ���ֽ�Ϊ��λ���� unicode ��
	 *
	 * @param file
	 * @param append
	 *            true:�ļ���׷�ӷ�ʽ��,false:�򸲸�ԭ�ļ�������
	 * @return
	 */
	public static FileOutputStream getFileOutputStream(File file, boolean append) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file, append);
		} catch (FileNotFoundException e) {
			System.out.print("������Ϣ:�ļ�������");
			e.printStackTrace();
		}
		return fileOutputStream;
	}

	/**
	 * �����ļ�·�������ļ���������� ���ֽ�Ϊ��λ���� unicode ��
	 *
	 * @param path
	 * @param append
	 *            true:�ļ���׷�ӷ�ʽ��,false:�򸲸�ԭ�ļ�������
	 * @return
	 */
	public static FileOutputStream getFileOutputStream(String filepath, boolean append) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filepath, append);
		} catch (FileNotFoundException e) {
			System.out.print("������Ϣ:�ļ�������");
			e.printStackTrace();
		}
		return fileOutputStream;
	}

	public static File getFile(String filepath) {
		return new File(filepath);
	}

	public static ByteArrayOutputStream getByteArrayOutputStream() {
		return new ByteArrayOutputStream();
	}

	private static int reverseBytes(Integer source) {
		if (source == null)
			source = 0;
		return Integer.reverseBytes(source);
	}

	private static long reverseBytes(Double source) {
		if (source == null)
			source = 0.0d;
		return Long.reverseBytes(Double.doubleToLongBits(source));
	}

	public static void writeStr(DataOutputStream dop, String value) {
		try {
			if (value == null || value.trim().length() == 0) {
				dop.writeInt(reverseBytes(0));
			} else {
				dop.writeInt(reverseBytes(value.getBytes().length));
				dop.write(value.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeDouble(DataOutputStream dop, Double value) {
		try {
			dop.writeLong(reverseBytes(value));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeInt(DataOutputStream dop, Integer value) {
		try {
			dop.writeInt(reverseBytes(value));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeBoolean(DataOutputStream dop, boolean value) {
		try {
			dop.writeBoolean(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
