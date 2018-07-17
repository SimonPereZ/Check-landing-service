'use strict';

var browserify = require('browserify');
var gulp = require('gulp');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');
var uglify = require('gulp-uglify');
var sourcemaps = require('gulp-sourcemaps');
var gutil = require('gulp-util');
var watchify = require('watchify');

gulp.task('build', function () {
    // gulp.task('javascript', function () {
    // set up the browserify instance on a task basis
    var b = browserify({
        entries: 'app/scripts/app.js',
        debug: true,
        cache: {},
        packageCache: {}
        // plugin: [watchify]
    });
    // b.on('update', bundle);
    bundle();

    function bundle() {
        b.bundle()
            .pipe(source('app.js'))
            .pipe(buffer())
            .pipe(sourcemaps.init({loadMaps: true}))
            // Add transformation tasks to the pipeline here.
            // .pipe(uglify())
            .on('error', gutil.log)
            .pipe(sourcemaps.write('./'))
            .pipe(gulp.dest('./src/main/webapp'));

    }

});


gulp.task('watch', function () {
    // gulp.task('javascript', function () {
    // set up the browserify instance on a task basis
    var b = browserify({
        entries: 'app/scripts/app.js',
        debug: true,
        cache: {},
        packageCache: {},
        plugin: [watchify]
    });
    b.on('update', bundle);
    bundle();

    function bundle() {
        b.bundle()
            .pipe(source('app.js'))
            .pipe(buffer())
            .pipe(sourcemaps.init({loadMaps: true}))
            // Add transformation tasks to the pipeline here.
            // .pipe(uglify())
            .on('error', gutil.log)
            .pipe(sourcemaps.write('./'))
            .pipe(gulp.dest('./src/main/webapp'));

    }

});
