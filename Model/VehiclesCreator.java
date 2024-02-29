package Model;

import java.awt.*;

public class VehiclesCreator {
    public Volvo240 createVolvo240(Color color, double x, double y, double direction) {
        return new Volvo240(color, x ,y ,direction);}
    public Saab95 createSaab95(Color color, double x, double y, double direction) {
        return new Saab95(color, x ,y ,direction);}
    public Scania createScania(Color color, double x, double y, double direction) {
        return new Scania(color, x ,y ,direction);}
    public Cartransporter3000 createCartransporter3000(Color color, double x, double y, double direction) {
        return new Cartransporter3000(color, x ,y ,direction);}
}
