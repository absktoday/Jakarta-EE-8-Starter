/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/FacesComponent.java to edit this template
 */
package io.absk.components;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(createTag = true)
public class markdown extends UIComponentBase {

    @Override
    public String getFamily() {
        return "io.absk.components";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        String message = (String) getAttributes().get("message");
        LocalDateTime time = (LocalDateTime) getAttributes().get("time");
        String formattedTime = time.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("p", this);
        writer.write("Message: " + message);
        writer.endElement("p");

        writer.startElement("p", this);
        writer.write("Time: " + formattedTime);
        writer.endElement("p");
    }

}
