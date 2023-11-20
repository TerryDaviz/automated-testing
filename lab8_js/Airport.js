const PassengerPlane = require('./Planes/PassengerPlane');
const MilitaryPlane = require('./Planes/MilitaryPlane');
const MilitaryType = require('./models/militaryType');
const experimentalPlane = require('./Planes/experimentalPlane');

class Airport {

    constructor(planes) {
        this.planes = planes;
    }

    static convertToString(planes) {
        return JSON.stringify(planes);
    }

    getPassengerPlanes() {
        return this.planes.filter(plane => plane instanceof PassengerPlane);
    }

    getMilitaryPlanes() {
        return this.planes.filter(plane => plane instanceof MilitaryPlanePlane);;
    }

    getPassengerPlaneWithMaxPassengersCapacity() {
        return Math.max(...this.getPassengerPlanes());
    }

    getTransportMilitaryPlanes() {
        return this.getMilitaryPlanes().filter(plane => plane.getMilitaryType() === MilitatyType.TRANSPORT);
    }

    getBomberMilitaryPlanes() {
        return this.getMilitaryPlanes().filter(plane => plane.getMilitaryType() === MilitaryType.BOMBER);
    }

    getExperimentalPlanes() {
        return this.planes.filter(plane => plane instanceof experimentalPlane);
    }

    sortByMaxDistance() {
        return this.planes.sort((a, b) => a.getMaxFlightDistance() - b.getMaxFlightDistance());
    }

    sortByMaxSpeed() {
        return this.planes.sort((a, b) => a - b);
    }

    sortByMaxLoadCapacity() {
        return this.planes.sort((a, b) => a - b);
    }

    getPlanes() {
        return this.planes;
    }

}

module.exports = Airport;
