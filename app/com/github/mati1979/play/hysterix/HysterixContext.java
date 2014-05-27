package com.github.mati1979.play.hysterix;

public class HysterixContext {

    private static final play.Logger.ALogger logger = play.Logger.of(HysterixCommand.class);

    private HysterixRequestCacheHolder hysterixRequestCacheHolder;
    private HysterixSettings hysterixSettings;
    private HysterixRequestLog hysterixRequestLog;

    public HysterixContext(final HysterixRequestCacheHolder hysterixRequestCacheHolder,
                           final HysterixSettings hysterixSettings,
                           final HysterixRequestLog hysterixRequestLog) {
        this.hysterixRequestCacheHolder = hysterixRequestCacheHolder;
        this.hysterixSettings = hysterixSettings;
        this.hysterixRequestLog = hysterixRequestLog;
    }

    public HysterixRequestCacheHolder getHysterixRequestCacheHolder() {
        return hysterixRequestCacheHolder;
    }

    public HysterixSettings getHysterixSettings() {
        return hysterixSettings;
    }

    public HysterixRequestLog getHysterixRequestLog() {
        return hysterixRequestLog;
    }

    public static HysterixContext create(final HysterixSettings hysterixSettings) {
        final StackTraceElement[] stackTrace = new RuntimeException("").getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            logger.debug(stackTraceElement.getClassName() + ":" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber());
        }
        logger.debug("create new HysterixContext:" + hysterixSettings);
        return new HysterixContext(new HysterixRequestCacheHolder(), hysterixSettings, new HysterixRequestLog());
    }

    public static HysterixContext empty() {
        return new HysterixContext(new HysterixRequestCacheHolder(), new HysterixSettings(), new HysterixRequestLog());
    }

}
