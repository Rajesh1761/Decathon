package com.kuehen.nagel.decathlon.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Airy Fabian Rosales
 * @date Sep-2019
 */
@XmlRootElement(name = "AthleticResults")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DataForXmlFile {

	@XmlElement(name = "Athlete")
	private List<AthleticResult> athletes;

}