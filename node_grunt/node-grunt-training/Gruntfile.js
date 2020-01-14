module.exports = function(grunt) {
	grunt.initConfig({
		uglify: {
			options: {
				mangle: false
			},
			dist: {
				files: {
					"dest/output.min.js": "js/script.js".    //compressed file: from version of file.
				}
			}
		}
	});
	grunt.loadNpmTasks("grunt-contrib-uglify");
	grunt.registerTask("default", ["uglify"]);
};
