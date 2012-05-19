package com.shanitay.client.robot;

import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Created By: Itay Sabato<br/>
 * Date: 05/05/12 <br/>
 * Time: 04:01 <br/>
 */
interface RobotBundle extends ClientBundle {
    @Source("robot.svg")
    @SVGResource.Validated(validated = false)
    SVGResource mainSvg();
}
