package datadog.trace.agent.decorator;

import io.opentracing.Span;
import io.opentracing.tag.Tags;
import datadog.trace.api.Config;

public abstract class ServerDecorator extends BaseDecorator {

  @Override
  public Span afterStart(final Span span) {
    assert span != null;
    Tags.SPAN_KIND.set(span, Tags.SPAN_KIND_SERVER);
    span.setTag(Config.LANGUAGE_TAG_KEY, Config.LANGUAGE_TAG_VALUE);
    return super.afterStart(span);
  }
}
