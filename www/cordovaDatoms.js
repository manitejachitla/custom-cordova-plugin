var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'cordovaDatoms', 'coolMethod', [arg0]);
};
exports.TrackUser = function (eventName,eventData={}, success, error) {
    exec(success, error, 'cordovaDatoms', 'TrackUser', [eventName,eventData]);
};

