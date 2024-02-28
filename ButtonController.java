import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonController {
    CarView frame;
    VehiclesAndShops vehicles;

    public ButtonController(CarView frame, VehiclesAndShops vehicles) {
        this.frame = frame;
        this.vehicles = vehicles;
        assignButtons();
    }

    void assignButtons() {
    frame.gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.gas(frame.gasAmount);
        }
    });
        frame.startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.startEngine();
        }
    });
        frame.stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.stopEngine();
        }
    });
        frame.brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.brake(frame.gasAmount);
        }
    });
        frame.turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.turboOn();
        }
    });
        frame.turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.turboOff();
        }
    });
        frame.liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.raiseRamp();
        }
    });
        frame.lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            vehicles.lowerRamp();
        }
    });
        frame.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicles.addCar();
            }
        });

        frame.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicles.removeCar();
            }
        });
    }}
