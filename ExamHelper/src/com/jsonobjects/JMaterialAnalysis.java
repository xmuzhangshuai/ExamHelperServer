package com.jsonobjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrw.idao.ISectionDao;

/**
 * Entity mapped to table MATERIAL_ANALYSIS.
 */
public class JMaterialAnalysis extends JQuestion {

	private Long id;
	/** Not-null value. */
	private String material;
	private String material_image;
	private String remark;
	private Boolean flag;
	private long section_id;

	public JMaterialAnalysis() {
	}

	public JMaterialAnalysis(Long id) {
		this.id = id;
	}

	public JMaterialAnalysis(Long id, String material, String material_image, String remark, Boolean flag,
			long section_id) {
		this.id = id;
		this.material = material;
		this.material_image = material_image;
		this.remark = remark;
		this.flag = flag;
		this.section_id = section_id;
	}

	/**
	 * 网络变为本地
	 * 
	 * @return
	 */
	public com.yrw.domains.Materialanalysis NetToLocal() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ISectionDao iSectionDao = (ISectionDao) applicationContext.getBean("sectionDao");

		com.yrw.domains.Materialanalysis local = new com.yrw.domains.Materialanalysis(
				iSectionDao.getSectionById(new Long(section_id).intValue()), material, material_image, remark, null);
		local.setId(id.intValue());
		return local;
	}

	/**
	 * 本地变为网络
	 * 
	 * @return
	 */
	public static JMaterialAnalysis LocalToNet(com.yrw.domains.Materialanalysis local) {
		JMaterialAnalysis net = new JMaterialAnalysis((long) local.getId(), local.getMaterial(),
				local.getMaterialImage(), local.getRemark(), false, local.getSection().getId());
		return net;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/** Not-null value. */
	public String getMaterial() {
		return material;
	}

	/**
	 * Not-null value; ensure this value is available before it is saved to the
	 * database.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMaterial_image() {
		return material_image;
	}

	public void setMaterial_image(String material_image) {
		this.material_image = material_image;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public long getSection_id() {
		return section_id;
	}

	public void setSection_id(long section_id) {
		this.section_id = section_id;
	}

}
