package messenger.dao;

import messenger.model.ShortChannelData;

import java.util.List;

public interface ShortChannelDAO  {

    List<ShortChannelData> getChannels();

}
